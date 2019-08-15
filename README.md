
## 开发规范和技术标准（白皮书）
* [组织结构](#组织结构)
* [开发流程](#开发流程)
* [会议组织流程](#会议组织流程)
* [需求管理规范](#需求管理规范)
* [开发规范](#开发规范)
    * [命名规范](#命名规范)
    * [编码规范](#编码规范)
    * [版本管理](#版本管理)
* [示例](#示例)
* [Folio基础框架](#Folio基础框架)
* [产品规范](#产品规范)
* [UX/UI设计规范](#UX/UI设计规范)
* [测试规范](#测试规范)
* [发行规范](#faxingguifan)
## 
* <font size=4  name="组织结构">组织结构</font>
* <font size=4>开发流程</font>
* <font size=4>会议组织流程</font>
    1. 上图LSP项目全体会议 <br>
        召集人：上图LSP项目经理负责召开<br>
        频次：每月一次<br>
        会议方式：上图现场参会+电话会议（存档）<br>
        会议内容：<br>
        * 各产品负责人汇报工作进展及工作计划
        * 问题讨论与解决
        * 各产品小组交流<br>

        存档：相关工作文档、会议记录及电话会议录像 <br>
    2. SIG会议 <br>
        召集人：SIG负责人（产品经理）负责召开<br>
        频次：每两周一次 / 根据需要召开<br>
        会议方式：电话会议<br>
        会议内容：<br>
        * 了解开发进度
        * 功能演示与确认
        * 收集整理产品需求
        * 分配开发任务 <br>
        
        存档：相关工作文档、会议记录 <br>
* <font size=4>需求管理规范</font>
* <font size=4>开发规范</font>
    * <font size=3>命名规范 </font> <br>
        <font size=3>包命名规范 </font> <br>
        包命名格式为：公司名.项目名.模块名。如：cn.sh.library.folio.xxx，其中 cn.sh.library为上图公司名，folio为项目名，xxx为具体的模块名。其他推荐包命名规则如下：<br>
            - bean：存放实体类文件<br>
            - entity：存放实体类文件(数据库层面)<br>
            - model：存放模型类文件<br>
            - dao：存放实体类文件<br>
            - service：存放服务层文件<br>
            - controller：存放控制层文件<br>
            - utils：存放工具类文件<br>
            - aspect：存放切面类文件<br>
            - converter：存放转换器文件<br>
            - interceptor：存放拦截器文件<br>
            - constant：常量类文件<br>

        <font size=3>数据库表字段命名规范 </font> <br>
            表命名格式为:公司名_模块名_明细表名称。如 shlibrary_modulename_xxxx，其中shlibrary为上图的公司名，modulename为模块名，xxxx为模块中具体设计的详细表名或功能点<br>
            其他相关数据库规范详见 <a href="http://sig.library.sh.cn:8090/pages/viewpage.action?pageId=2818252">PostgreSQL 数据库开发规范</a><br><br><br>


    * <font size=3>编码规范 </font> <br>
        <font size=3>CheckStyle </font> <br>
        <a href="https://checkstyle.sourceforge.io/">Checkstyle</a>是一款检查java程序代码样式的工具，可以有效的帮助我们检查代码以便更好的遵循代码编写标准。<br>
        上图LSP编码规范采用google规范(<font color='rgb(255,102,0)'>暂定</font>)，具体规范内容详见 <a href="http://sig.library.sh.cn:8090/download/attachments/2818186/google-java-styleguide-zh.pdf?version=1&modificationDate=1556165372952&api=v2">Google Java 编程规范(中文版)</a> <br>
        checkstyle.xml文件内容详见 <a href="https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml">google_checkstyle.xml</a> <br> <br> <br>

    * <font size=3>版本管理 </font> <br>
        <font size=3>版本号 </font> <br>
        版本号管理采用 语义版本号 进行管理<br>
        软件版本号，由三部分组成，如 1.8.2<br>
        接口版本号，由于接口定义没有具体实现，所以只包含前面两部分，如 1.8<br>
        第一个数字是主要版本。每当进行非严格向后兼容的更改时，它都需要递增，例如删除功能或更改语义。<br>
        第二个数字是次要版本。无论何时进行向后兼容的更改，例如添加新功能或可选字段，都需要对其进行递增。<br>
        第三个数字是软件版本。应该增加不影响接口的更改，例如修复bug或提高效率。<br><br> <br>
        
* <font size=4>示例</font>
    * Vertx

        [官方示例](https://github.com/vert-x3/vertx-examples "官方示例") <br>
        [其他示例](https://github.com/x19990416/vertx-examples "其他示例")
### Folio基础框架
<table>
<th>名称</th><th>版本号</th><th>备注</th>
<tbody>
<tr>
<td>JAVA SDK</td>
<td>1.8.x</td>
<td></td>
</tr>
<tr>
<td>Postgresql</td>
<td>9.6</td>
<td>
<li><a href="https://www.postgresql.org/">https://www.postgresql.org/</a></li>
<li><a href="http://sig.library.sh.cn:8090/pages/viewpage.action?pageId=2818252">PostgreSQL 数据库开发规范</a></li>
</td>
</tr>
<tr>
<td>Vert.x</td>
<td>3.7.0</td>
<td>
Vert.x 开发指南（英文版）<a href="http://sig.library.sh.cn:8090/pages/viewpage.action?pageId=2818186&preview=/2818186/2818235/Vert.x%20for%20Java%20%E5%BC%80%E5%8F%91%E8%80%85.pdf">Vert.x for Java 开发者.pdf</a><br>
Vertx. 开发指南 (中文翻译版)<a href="https://vertxchina.github.io/vertx-translation-chinese/">Vert.x 官方文档中文翻译 v3.4.1</a>

</td>
</tr>
<tr>
<td>Stripes</td>
<td>2.0.0</td>
<td><a href="https://github.com/folio-org/stripes/blob/master/README.md">Stripes 开发指南</a></td>
</tr>
<tr>
<td>Okapi</td>
<td>2.27.1</td>
<td><a href="https://github.com/folio-org/okapi/blob/master/doc-zh/guide.md">Okapi 参考指南</a></td>
</tr>
</tbody>
</table>

* <font size=4>产品规范</font>
* <font size=4>UX/UI设计规范</font> <br>
    参考Folio UX设计规范。[https://ux.folio.org/docs/](https://ux.folio.org/docs/)
* <font size=4>测试规范</font>
* <font size=4 > <a href="#faxingguifan">发行规范<a></font>

<style type="text/css">  
table {
    width: 100%; /*表格宽度*/
    max-width: 65em; /*表格最大宽度，避免表格过宽*/
    border: 1px solid #dedede; /*表格外边框设置*/
    margin: 15px auto; /*外边距*/
    border-collapse: collapse; /*使用单一线条的边框*/
    empty-cells: show; /*单元格无内容依旧绘制边框*/
}
table th,
table td {
  height: 35px; /*统一每一行的默认高度*/
  border: 1px solid #dedede; /*内部边框样式*/
  padding: 0 10px; /*内边距*/
}
table th {
    font-weight: bold; /*加粗*/
    text-align: center !important; /*内容居中，加上 !important 避免被 Markdown 样式覆盖*/
    background: rgba(158,188,226,0.2); /*背景色*/
}
</style>

