# AtlasDemo
阿里Atlas组件框架的使用
 
项目结构：   
DemoTest 包含修复前apk包、修复前加固apk包、更新补丁、远程bundle作为演示使用。   
app 主项目   
loadingbundle 远程加载组件 不打包进apk   
homebundle 加载组件 打包进apk   
middlewarelibrary 公共方法库 宿主与组件使用   

DemoTest简单使用：   
1、安装修复前apk包到手机   
2、把更新补丁、远程bundle放入到SD卡Android/data/com.android.dzatlas/cache/目录下   
3、打开应用点击更新，重新打开就可以看见被修复后的内容   
   
项目使用流程：   
1、使用最新的Android studio开发工具、更新到最新的gradle-3.3-all   
2、编译apk包 gradlew assembleDebug 后安装到手机    
3、发布到本地仓库 mgradlew publish   
4、修改版本号、修改项目内容、打差异包 gradlew assembleDebug -DapVersion=1.1.0 -DversionName=1.1.1   
5、把生成的补丁文件放入sd卡目录打开app更新补丁   
   