function tiaozhuan(tip,url){
	var sz=3;
	var intervalid;
	document.write(tip+"<br>");
	document.write("<span id='tzsz'>3</span>");
	document.write("秒后将跳转页面");
	intervalid = setInterval(fun, 1000);
	function fun() {
		sz--;
		if(sz==0){
			window.clearInterval(intervalid); 
			window.location.href = url;
		}
		else{
			document.getElementById("tzsz").innerHTML=sz;
		}
	}
}
function getRootPath(){
	//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath=window.document.location.href;
	//获取主机地址之后的目录，如： /uimcardprj/share/meun.jsp
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8083
	var localhostPaht=curWwwPath.substring(0,pos);
	//获取带"/"的项目名，如：/uimcardprj
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	return(projectName);
}
function sendPost(){
	var httpRequest = new XMLHttpRequest();//第一步：创建需要的对象
	httpRequest.open('POST', 'url', true); //第二步：打开连接
	httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");//设置请求头 注：post方式必须设置请求头（在建立连接后设置请求头）
	httpRequest.send('name=teswe&ee=ef');//发送请求 将情头体写在send中
	/**
	 * 获取数据后的处理程序
	 */
	httpRequest.onreadystatechange = function () {//请求后的回调接口，可将请求成功后要执行的程序写在其中
	    if (httpRequest.readyState == 4 && httpRequest.status == 200) {//验证请求是否发送成功
	        var json = httpRequest.responseText;//获取到服务端返回的数据
	        console.log(json);
	    }
	};
}

