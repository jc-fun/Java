function $(id) {
    return document.getElementById(id);
}

//document.forms[0].uname
function preRegist() {
    let unameTxt = $("unameTxt");
    let unameReg = /[0-9a-zA-Z]{6,16}/;
    let isPass = unameReg.test(unameTxt.value);
    let unameSpan = $("unameSpan");
    if (!isPass) {
        unameSpan.style.visibility = "visible";
        return false;
    } else {
        unameSpan.style.visibility = "hidden";
    }


    let pwdTxt = $("pwdTxt");
    let pwdReg = /.{8,}/;
    isPass = pwdReg.test(pwdTxt.value);
    let pwdSpan = $("pwdSpan");
    if (!isPass) {
        pwdSpan.style.visibility = "visible";
        return false;
    } else {
        pwdSpan.style.visibility = "hidden";
    }


    let pwdTxt2 = $("pwdTxt2");
    if (pwdTxt2.value !== pwdTxt.value) {
        $("pwdSpan2").style.visibility = "visible";
        return false;
    } else {
        $("pwdSpan2").style.visibility = "hidden";
    }

    let emailTxt = $("emailTxt");
    let emailReg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    isPass = emailReg.test(emailTxt.value);
    let emailSpan = $("emailSpan");
    if (!isPass) {
        emailSpan.style.visibility = "visible";
        return false;
    } else {
        emailSpan.style.visibility = "hidden";
    }

    return true;
}

// 如果想要发送异步请求，我们需要一个关键的对象 XMLHttpRequest
let xmlHttpRequest;

function createXMLHttpRequest() {
    if (window.XMLHttpRequest) {
        // 符合DOM2标准的浏览器，xmlHttpRequest的创建方式
        xmlHttpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) { // IE浏览器
        try {
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
        }
    }
}

function ckUname(uname) {
    createXMLHttpRequest();
    let url = "user.do?operate=ckUname&uname=" + uname;
    xmlHttpRequest.open("get", url, true);
    // 设置回调函数
    xmlHttpRequest.onreadystatechange = ckUnameCB;
    xmlHttpRequest.send();
}

function ckUnameCB() {
    if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
        // xmlHttpRequest.responseText 表示服务器响应的文本内容
        //alert(xmlHttpRequest.responseText);
        let responseText = xmlHttpRequest.responseText;
        // {'uname':'1'}
        //let result = eval(responseText);
        //alert(responseText);
        //eval("console.log(responseText)");
        //console.log(responseText === "{'uname':'1'}");
        if(responseText === "{'uname':'1'}") {
            alert("用户名已经被注册!");
        } else {
            alert("用户名可以注册");
        }
    }
}