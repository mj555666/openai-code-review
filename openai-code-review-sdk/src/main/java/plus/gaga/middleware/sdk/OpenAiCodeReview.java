package plus.gaga.middleware.sdk;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class OpenAiCodeReview {

    public static void main(String[] args) throws Exception {
        System.out.println("测试执行");

        // 1. 代码检出
        //这里创建的ProcessBuilder对象，用于执行Git命令，这个命令是git diff HEAD~1 HEAD，他将比较当前提交和上一个提交之间的代码差异
        ProcessBuilder processBuilder = new ProcessBuilder("git", "diff", "HEAD~1", "HEAD");
        //这里是设置执行目录，.表示当前目录
        processBuilder.directory(new File("."));

        //使用processBuilder启动命令，并返回一个Process对象
        Process process = processBuilder.start();

        //这里创建一个BufferedReader来读取命令执行的标准输出流。每次读取一行数据，将其添加到diffCode字符串构建器中。最终 diffCode 会包含 Git diff 输出的所有内容，即代码差异。
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;

        StringBuilder diffCode = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            diffCode.append(line);
        }

        //等待Git命令执行完毕，获取进程的退出码，0表示执行成功，否则表示发生错误
        int exitCode = process.waitFor();
        System.out.println("Exited with code:" + exitCode);

        System.out.println("评审代码：" + diffCode.toString());
    }

}
