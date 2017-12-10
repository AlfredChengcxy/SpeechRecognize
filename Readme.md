
# Next Step
integrate writeToFile Util

过滤通用的含有许川的句子。

Java SDK Document：http://www.xfyun.cn/doccenter/lfasr#go_sdk_doc_v2

A demo based 语音听写： http://blog.csdn.net/u012635169/article/details/51049752

# Prepare

File Type Support：
    public enum LfasrType {
    LFASR_STANDARD_RECORDED_AUDIO("标准版-已录制音频", "wav,flac,opus,mp3,`m4a`", 0),
    LFASR_TELEPHONY_RECORDED_AUDIO("电话专用版-已录制音频", "wav,flac,mp3", 2);

The type of Huawei P7 recorded audio is amr.
ios is `m4a` .

String local_file, // 本地音频路径及文件名 
LfasrType lfasr_type, // 本地音频对应类型
HashMap<String, String> params, // 用户自定义参数，可传递suid，has_participle（是否分词）
    max_alternatives（多候选词），not_wait（是否同步等待），suid为用户自定义标识字符串，
    has_participle为true或`false`字符串，max_alternatives 为1-10整数，not_wait为true或false字符串。

Q：语音云的API能够识别的音频格式
A：目前只支持pcm格式的音频文件。

# Test
## Speed
  a 6 MB mp3, less than 4 min.

## Data Return in JSon
Message resultMsg = lc.lfasrGetResult(task_id);
String jsonString = resultMsg.getData();

This position needs a picture.


  