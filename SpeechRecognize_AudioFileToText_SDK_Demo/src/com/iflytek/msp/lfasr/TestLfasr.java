package com.iflytek.msp.lfasr;

import java.util.HashMap;

import org.apache.log4j.PropertyConfigurator;

import com.alibaba.fastjson.JSON;
import com.iflytek.msp.cpdb.lfasr.client.LfasrClientImp;
import com.iflytek.msp.cpdb.lfasr.exception.LfasrException;
import com.iflytek.msp.cpdb.lfasr.model.LfasrType;
import com.iflytek.msp.cpdb.lfasr.model.Message;
import com.iflytek.msp.cpdb.lfasr.model.ProgressStatus;

//
public class TestLfasr
{
	// ????????
	private static final String local_file = "inputfailed.mp3";
	/*
	 * ??????????????????
	 * LfasrType.LFASR_STANDARD_RECORDED_AUDIO ? LfasrType.LFASR_TELEPHONY_RECORDED_AUDIO
	 * */
	private static final LfasrType type = LfasrType.LFASR_STANDARD_RECORDED_AUDIO;
	// ???????
	private static int sleepSecond = 20;

	public static void main(String[] args) {
		// ??????
		PropertyConfigurator.configure("log4j.properties");

		// ???LFASR??
		LfasrClientImp lc = null;
		try {
			lc = LfasrClientImp.initLfasrClient();
		} catch (LfasrException e) {
			// ??????????????
			Message initMsg = JSON.parseObject(e.getMessage(), Message.class);
			System.out.println("ecode=" + initMsg.getErr_no());
			System.out.println("failed=" + initMsg.getFailed());
		}

		// ??????ID
		String task_id = "";
		HashMap<String, String> params = new HashMap<>();
		params.put("has_participle", "true");
		try {
			// ??????
			Message uploadMsg = lc.lfasrUpload(local_file, type, params);

			// ?????
			int ok = uploadMsg.getOk();
			if (ok == 0) {
				// ??????
				task_id = uploadMsg.getData();
				System.out.println("task_id=" + task_id);
			} else {
				// ??????-?????
				System.out.println("ecode=" + uploadMsg.getErr_no());
				System.out.println("failed=" + uploadMsg.getFailed());
			}
		} catch (LfasrException e) {
			// ?????????????
			Message uploadMsg = JSON.parseObject(e.getMessage(), Message.class);
			System.out.println("ecode=" + uploadMsg.getErr_no());
			System.out.println("failed=" + uploadMsg.getFailed());
		}

		// ??????????
		while (true) {
			try {
				// ??1min????????????????????????1????????break????????2???????????break????????4???8?????
				Thread.sleep(sleepSecond * 1000);
				System.out.println("waiting ...");
			} catch (InterruptedException e) {
			}
			try {
				// ??????
				Message progressMsg = lc.lfasrGetProgress(task_id);

				// ?????????0??????
				if (progressMsg.getOk() != 0) {
					System.out.println("task was fail. task_id:" + task_id);
					System.out.println("ecode=" + progressMsg.getErr_no());
					System.out.println("failed=" + progressMsg.getFailed());

					// ???????-????????????????????????
					// ?????????????
					// 1. ???????????
					// 2. ?????????
					continue;
				} else {
					ProgressStatus progressStatus = JSON.parseObject(progressMsg.getData(), ProgressStatus.class);
					if (progressStatus.getStatus() == 9) {
						// ????
						System.out.println("task was completed. task_id:" + task_id);
						break;
					} else {
						// ?????
						System.out.println("task was incomplete. task_id:" + task_id + ", status:" + progressStatus.getDesc());
						continue;
					}
				}
			} catch (LfasrException e) {
				// ???????????????????????????
				Message progressMsg = JSON.parseObject(e.getMessage(), Message.class);
				System.out.println("ecode=" + progressMsg.getErr_no());
				System.out.println("failed=" + progressMsg.getFailed());
			}
		}

		// ??????
		try {
			Message resultMsg = lc.lfasrGetResult(task_id);
			System.out.println(resultMsg.getData());
			// ????????0????????
			if (resultMsg.getOk() == 0) {
				// ??????
				System.out.println(resultMsg.getData());
			} else {
				// ???????????????
				System.out.println("ecode=" + resultMsg.getErr_no());
				System.out.println("failed=" + resultMsg.getFailed());
			}
		} catch (LfasrException e) {
			// ?????????????????
			Message resultMsg = JSON.parseObject(e.getMessage(), Message.class);
			System.out.println("ecode=" + resultMsg.getErr_no());
			System.out.println("failed=" + resultMsg.getFailed());
		}
	}
}
