package com.framework.commons.utils;

import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @project 电子档案项目
 * @file NetFtpUtils.java 创建时间:2020年5月4日下午8:42:47
 * @description 
 * @author   zxj
 */
public class NetFtpUtils {

 // ftp服务器地址
    private String hostname = "127.0.0.1";
    // ftp服务器端口号默认为21
    private Integer port = 21;
    // ftp登录账号
    private String username = "da";
    // ftp登录密码
    private String password = "da";
    //ftp客户端
    private FTPClient ftpClient = null;
 
//    /**
//     * 初始化ftp服务器
//     */
//    private boolean initFtpClient(TUserDzwjRoot tUserDzwjRoot) {
//        ftpClient = new FTPClient();
//        ftpClient.setControlEncoding("utf-8");
//        /*
//        hostname=tUserDzwjRoot.getFtpip();
//        username=tUserDzwjRoot.getFtpuser();
//        password=tUserDzwjRoot.getFtppwd();
//        */
//        try {
//            System.out.println("ftp服务器:" + this.hostname + ":" + this.port);
//            ftpClient.connect(hostname, port); // 连接ftp服务器
//            ftpClient.login(username, password); // 登录ftp服务器
//            int replyCode = ftpClient.getReplyCode(); // 是否成功登录服务器
//            if (!FTPReply.isPositiveCompletion(replyCode)) {
//                System.out.println("连接失败...ftp服务器:" + this.hostname + ":" + this.port);
//            }
//            System.out.println("连接成功...ftp服务器:" + this.hostname + ":" + this.port);
//            return true;
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            System.out.println("连接失败...ftp服务器:" + this.hostname + ":" + this.port);
//            return false;
//        } catch (IOException e) {
//            System.out.println("连接失败...ftp服务器:" + this.hostname + ":" + this.port);
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 上传文件
//     *
//     * @param pathname
//     *            ftp服务保存地址
//     * @param fileName
//     *            上传到ftp的文件名
//     * @param originfilename
//     *            待上传文件的名称（绝对地址） *
//     * @return
//     */
//    public boolean uploadFile(String pathname, String fileName, String originfilename,TUserDzwjRoot tUserDzwjRoot) {
//        InputStream inputStream = null;
//        try {
//            System.out.println("开始上传文件");
//            inputStream = new FileInputStream(new File(originfilename));
//            if (!initFtpClient(tUserDzwjRoot) )
//            {
//                return false;
//            }
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//            CreateDirecroty(pathname);
//            ftpClient.makeDirectory(pathname);
//            ftpClient.changeWorkingDirectory(pathname);
//            // 每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据
//            ftpClient.enterLocalPassiveMode();
//            // 观察是否真的上传成功
//            boolean storeFlag = ftpClient.storeFile(fileName, inputStream);
//            System.err.println("storeFlag==" + storeFlag);
//            inputStream.close();
//            ftpClient.logout();
//            System.out.println("上传文件成功");
//        } catch (Exception e) {
//            System.out.println("上传文件失败");
//            e.printStackTrace();
//        } finally {
//            if (ftpClient.isConnected()) {
//                try {
//                    ftpClient.disconnect();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (null != inputStream) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return true;
//    }
//
//    /**
//     * 上传文件
//     *
//     * @param pathname
//     *            ftp服务保存地址
//     * @param fileName
//     *            上传到ftp的文件名
//     * @param inputStream
//     *            输入文件流
//     * @return
//     */
//    public boolean uploadFile(String pathname, String fileName, InputStream inputStream,TUserDzwjRoot tUserDzwjRoot) {
//        try {
//            System.out.println("开始上传文件");
//            if (!initFtpClient(tUserDzwjRoot) )
//            {
//                return false;
//            }
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//            CreateDirecroty(pathname);
//            ftpClient.makeDirectory(pathname);
//            ftpClient.changeWorkingDirectory(pathname);
//            ftpClient.storeFile(fileName, inputStream);
//            inputStream.close();
//            ftpClient.logout();
//            System.out.println("上传文件成功");
//        } catch (Exception e) {
//            System.out.println("上传文件失败");
//            e.printStackTrace();
//        } finally {
//            if (ftpClient.isConnected()) {
//                try {
//                    ftpClient.disconnect();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (null != inputStream) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return true;
//    }
//
//    // 改变目录路径
//    public boolean changeWorkingDirectory(String directory) {
//        boolean flag = true;
//        try {
//            flag = ftpClient.changeWorkingDirectory(directory);
//            if (flag) {
//                System.out.println("进入文件夹" + directory + " 成功！");
//
//            } else {
//                System.out.println("进入文件夹" + directory + " 失败！开始创建文件夹");
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        return flag;
//    }
//
//    // 创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
//    public boolean CreateDirecroty(String remote) throws IOException {
//        boolean success = true;
//        String directory = remote + "/";
//        // 如果远程目录不存在，则递归创建远程服务器目录
//        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
//            int start = 0;
//            int end = 0;
//            if (directory.startsWith("/")) {
//                start = 1;
//            } else {
//                start = 0;
//            }
//            end = directory.indexOf("/", start);
//            String path = "";
//            String paths = "";
//            while (true) {
//                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), StandardCharsets.ISO_8859_1 );
//                path = path + "/" + subDirectory;
//                if (!existFile(path)) {
//                    if (makeDirectory(subDirectory)) {
//                        changeWorkingDirectory(subDirectory);
//                    } else {
//                       // System.out.println("创建目录[" + subDirectory + "]失败");
//                        changeWorkingDirectory(subDirectory);
//                    }
//                } else {
//                    changeWorkingDirectory(subDirectory);
//                }
//
//                paths = paths + "/" + subDirectory;
//                start = end + 1;
//                end = directory.indexOf("/", start);
//                // 检查所有目录是否创建完毕
//                if (end <= start) {
//                    break;
//                }
//            }
//        }
//        return success;
//    }
//
//    // 判断ftp服务器文件是否存在
//    public boolean existFile(String path) throws IOException {
//        boolean flag = false;
//        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
//        if (ftpFileArr.length > 0) {
//            flag = true;
//        }
//        return flag;
//    }
//
//    // 创建目录
//    public boolean makeDirectory(String dir) {
//        boolean flag = true;
//        try {
//            flag = ftpClient.makeDirectory(dir);
//            if (flag) {
//                System.out.println("创建文件夹" + dir + " 成功！");
//
//            } else {
//                System.out.println("创建文件夹" + dir + " 失败！");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return flag;
//    }
//
//    /**
//     * * 下载文件 *
//     *
//     * @param pathname
//     *            FTP服务器文件目录 *
//     * @param filename
//     *            文件名称 *
//     * @param localpath
//     *            下载后的文件路径 *
//     * @return
//     */
//    public boolean downloadFile(String pathname, String filename, String localpath,TUserDzwjRoot tUserDzwjRoot) {
//        boolean flag = false;
//        OutputStream os = null;
//        try {
//            System.out.println("开始下载文件");
//            if (!initFtpClient(tUserDzwjRoot) )
//            {
//                return false;
//            }
//            // 切换FTP目录
//            boolean changeFlag = ftpClient.changeWorkingDirectory(pathname);
//            System.err.println("changeFlag==" + changeFlag);
//
//            ftpClient.enterLocalPassiveMode();
//            ftpClient.setRemoteVerificationEnabled(false);
//            // 查看有哪些文件夹 以确定切换的ftp路径正确
//            //String[] a = ftpClient.listNames();
//            //System.err.println(a[0]);
//            new File(localpath).getParentFile().mkdirs();
//            FTPFile[] ftpFiles = ftpClient.listFiles();
//            for (FTPFile file : ftpFiles) {
//                if (filename.equalsIgnoreCase(file.getName())) {
//                    File localFile = new File(localpath);
//                    os = new FileOutputStream(localFile);
//                    ftpClient.retrieveFile(file.getName(), os);
//                    os.close();
//                }
//            }
//            ftpClient.logout();
//            flag = true;
//            System.out.println("下载文件成功");
//        } catch (Exception e) {
//            System.out.println("下载文件失败");
//            e.printStackTrace();
//        } finally {
//            if (ftpClient.isConnected()) {
//                try {
//                    ftpClient.disconnect();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (null != os) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return flag;
//    }
//
//    /**
//     * * 删除文件 *
//     * ftp.deleteFile("/home/ftpFile", "12333.txt");
//     * @param pathname
//     *            FTP服务器保存目录 *
//     * @param filename
//     *            要删除的文件名称 *
//     * @return
//     */
//    /**
//     *@name
//     *@Description
//     *@Time    创建时间:2020年5月4日下午8:42:20
//     *@param pathname
//     *@param filename
//     *@param tUserDzwjRoot
//     *@return
//     *@author   zxj
//     *@history
//     */
//    public boolean deleteFile(String pathname, String filename,TUserDzwjRoot tUserDzwjRoot) {
//        boolean flag = false;
//        try {
//            System.out.println("开始删除文件");
//            if (!initFtpClient(tUserDzwjRoot) )
//            {
//                return false;
//            }
//            // 切换FTP目录
//            ftpClient.changeWorkingDirectory(pathname);
//            ftpClient.dele(filename);
//            ftpClient.logout();
//            flag = true;
//            System.out.println("删除文件成功");
//        } catch (Exception e) {
//            System.out.println("删除文件失败");
//            e.printStackTrace();
//        } finally {
//            if (ftpClient.isConnected()) {
//                try {
//                    ftpClient.disconnect();
//                    System.out.println("断开连接");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return flag;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(""+(new File("uu")).getAbsolutePath());
//        NetFtpUtils ftp = new NetFtpUtils();
//        TUserDzwjRoot tUserDzwjRoot=new TUserDzwjRoot();
//        /*
//        tUserDzwjRoot.setFtpip("127.0.0.1");
//        tUserDzwjRoot.setFtpuser("da");
//        tUserDzwjRoot.setFtppwd("dada");
//        */
//        // 文件路径写为用户建立时 指定的目录
//        ftp.uploadFile("/home/ftpFile", "12333.txt", "F:\\doctest\\12333.txt",tUserDzwjRoot);
//
//        //ftp.downloadFile("/home/ftpFile", "12333.txt", "E:\\tmp",tUserDzwjRoot);
//        //ftp.deleteFile("/home/ftpFile", "12333.txt",tUserDzwjRoot);
//        System.out.println("ok");
//    }

}
