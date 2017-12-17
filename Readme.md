
# Next Step
integrate writeToFile Util

过滤通用的含有许川的句子。

字符串过滤 工具类  支持通配符z：


本期本案感谢知乎用户冯丹彤的授权，想提高你的感情把控力吗。在我的微信公众号万能的川哥回复关键字成长，免费索取三食堂情感课程资料，如果你有非常困惑的问题，可以使用公众号里的私密提问，我会尽快亲自回答你，想看具体的情感案例分析。就在我的微博许川。每天晚上的视频脱口秀川哥真心话。人生总有一些故事值得被记住，也许你心里也有。愿意把你的故事讲给我吗难忘的愤怒的得意的心碎的，请私信我的微信公众号万能的川哥，把你的故事悄悄告诉我，我的节目每天晚上9点更新，和你一起改变，做更好的自己。



Java SDK Document：http://www.xfyun.cn/doccenter/lfasr#go_sdk_doc_v2

A demo based 语音听写： http://blog.csdn.net/u012635169/article/details/51049752

# Attention about how to organize source  files, such as config.properties and log4j.properties



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


# Error Code Query


0-12000 http://www.xfyun.cn/doccenter/faq?go=contitle66
20000-  http://www.xfyun.cn/doccenter/lfasr#go_sdk_doc_v2




# Test
## Speed
  a 6 MB mp3, less than 4 min.

## Data Return in JSon
Message resultMsg = lc.lfasrGetResult(task_id);
String jsonString = resultMsg.getData();

This position needs a picture.


  
