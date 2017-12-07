Java SDK Document：http://www.xfyun.cn/doccenter/lfasr#go_sdk_doc_v2

String local_file, // 本地音频路径及文件名 
LfasrType lfasr_type, // 本地音频对应类型
HashMap<String, String> params, // 用户自定义参数，可传递suid，has_participle（是否分词），
max_alternatives（多候选词），not_wait（是否同步等待），suid为用户自定义标识字符串，
has_participle为true或false字符串，max_alternatives 为1-10整数，not_wait为true或false字符串。