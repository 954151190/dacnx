<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>河北大厂农村商业银行股份有限公司</title>
<meta name="keywords" content="河北大厂农村商业银行股份有限公司" />
<meta name="description" content="河北大厂农村商业银行股份有限公司" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/webskys.js"></script>
<script type="text/javascript" src="js/ie6png.js"></script>
<script type="text/javascript" src="js/gun.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
</head>
<body>
	<div class="top">
		<div class="topright">
			<ul>
				<li class="li01"><a href='toIndex'>首页</a></li>
				<li class="li02"><a href='javascript:void();'
					onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.mycodes.net');"
					rel="nofollow">设为首页</a></li>
				<li class="li03"><a
					onclick="window.external.addFavorite(location.href,document.title)"
					href="javascript:void();" rel="nofollow">加入收藏</a></li>
			</ul>
		</div>
		<div class="logo">
			<a href="toIndex" title="-河北大厂农村商业银行股份有限公司"><img
				src="images/logo.png" width="502" height="71" alt="河北大厂农村商业银行股份有限公司" /></a>
		</div>
		<div class="righttel">
			<img src="images/tel.png" width="200" height="30" alt="前端设计联系电话" />
		</div>
		<div class="webnav">
			<ul>
				<li><a href="toIndex" title="网站首页">网站首页</a></li>
				<li class="licur"><a href="toAricleList?articleType=BL" title="公示公告">公示公告</a></li>
				<li><a href="toAricleList?articleType=NL" title="农信要闻">农信要闻</a></li>
				<li><a href="toAricleList?articleType=PL" title="产品展示">产品展示</a></li>
				<li><a href="toAricleList?articleType=SL" title="业务介绍">业务介绍</a></li>
				<!-- 
				<li><a href="#" title="其他模块">其他模块</a></li>
				<li><a href="#" title="其他模块">其他模块</a></li>
				<li><a href="#" title="其他模块">其他模块</a></li>
				<li><a href="#" title="其他模块">其他模块</a></li>
				 -->
			</ul>
		</div>
	</div>
	<div class="banner">
		<div id="banlbar"></div>
		<div id="banrbar"></div>
		<div id="banh">
			<ul>
				<s:iterator value="photoList" var="photos">
					<li><img src="showPhoto?photoType=0&photo.id=${ photos.id }" /></li>
				</s:iterator>
			</ul>
		</div>
	</div>
	<div class="index_con">
		<div class="page_left">
			<h2 class="left_title">公示公告</h2>
			<div class="leftbg borl_r">
				<ul class="classul">
					<li><a href="#">公示公告</a></li>
				</ul>
			</div>
			<div class="left_bot"></div>
		</div>
		<div class="page_right">
			<div class="pagetop">
				<span class="web_navi">当前位置：<a href="#">首页</a> &gt;&gt; 公示公告
				</span>
				<h2>公示公告</h2>
			</div>
			<div class="borl_r news_con">
				<h1>${bulletin.title }</h1>
				<p class="nets_zd">发布时间：${bulletin.create_time } 作者：${bulletin.author_name }</p>
				<div class="news_xq">
					<script id="editor" type="text/plain" style="width:100%;height:500px;">${bulletin.content }</script>
				<ul class="xq_np">
					<li><b>上一页：</b><a href="#" title="">但当我第一次坐下来阅读它的全部特性以了解</a></li>
					<li><b>下一页：</b><a href="#" title="">候，它并没有让我感到开窍。你可以想象的到</a></li>
				</ul>
				</div>
			</div>
			<div class="page_bot"></div>
		</div>
		<div class="clear"></div>
		<div class="blank10"></div>
		<div class="bot_nav"></div>
		<div class="bottom">
			<div class="patecopy">
				<p>
					Powered by <strong>河北大厂农村商业银行股份有限公司</strong> &copy; 2011-2015 All Right
					Reserved.
				</p>
				<p>
					<a href="#" target="_blank">浙ICP备11005891号</a>
				</p>
			</div>
		</div>
	</div>
<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');


    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }
</script>
</body>
</html>
