# PicEncryptApp

## 项目介绍
PicEncrypt是我在大学的本科毕业设计中做出来的一个android app。<br>
这个app是毕业设计的主题——图像置乱算法的一个载体，核心内容是图像置乱算法的实现与优化。<br>
图像加解密原理是基于刘向东等人的论文——[《基于排序变换的混沌图像置乱算法》](https://github.com/goldsudo/PicEncryptApp/blob/master/%E5%9F%BA%E4%BA%8E%E6%8E%92%E5%BA%8F%E5%8F%98%E6%8D%A2%E7%9A%84%E6%B7%B7%E6%B2%8C%E5%9B%BE%E5%83%8F%E7%BD%AE%E4%B9%B1%E7%AE%97%E6%B3%95.pdf)进行优化的结果。<br>
对于该法的分析和优化过程我写在了毕业论文中[《基于排序变换和混沌Logistic映射的图像置乱算法》](https://github.com/goldsudo/PicEncryptApp/blob/master/%E5%9F%BA%E4%BA%8E%E6%8E%92%E5%BA%8F%E5%8F%98%E6%8D%A2%E5%92%8C%E6%B7%B7%E6%B2%8CLogistic%E6%98%A0%E5%B0%84%E7%9A%84%E5%9B%BE%E5%83%8F%E7%BD%AE%E4%B9%B1%E7%AE%97%E6%B3%95.docx)，感兴趣的话可以查看论文的第三、四章<br><br>
整个项目其实是一个eclipse中的android项目，依赖ADT以及安卓sdk，如果需要在本地跑起来，需要进行android的环境配置。<br>
也可以直接下载打包好的apk文件直接安装在手机上：

## 项目演示
app安装成功后如下图中的PicEncrypt所示:
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/app-icon.jpg)
<br>
启动画面：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/start.jpg)
<br>
主页面：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/index.jpg)
<br>
打开相册：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/photos.jpg)
<br>
选中图片：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/choose.jpg)
<br>
输入密钥进行加密：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/input-key.jpg)
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/enc.jpg)
<br>
加密结果：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/enc-res.jpg)
<br>
输入相同的密钥即可解密：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/dec.jpg)
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/dec-res.jpg)
<br>
密钥的输入限制：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/check.jpg)
<br>
解密过程中可添加噪声，以模仿数据传输过程中的失真：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/add-noise.jpg)
<br>
添加噪声后的解密结果，可以发现噪声并不影响图像的整体还原：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/noise.jpg)
<br>
图像色值直方图：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/zhifangtu.jpg)
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/zhifang.jpg)
<br>
项目UML类图：
![image](https://github.com/goldsudo/PicEncryptApp/blob/master/SNAP-SHOT/UML.jpg)
