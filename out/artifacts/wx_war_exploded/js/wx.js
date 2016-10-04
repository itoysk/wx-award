$(function() {

    //输入手机号
    var mobileNum=prompt("请输入您的手机号","");

    if (mobileNum!=null && mobileNum != "")
    {
        //校验手机号是否能领取奖品
        $.ajax({
            type : 'GET',
            url : 'awardValidateServlet?phone='+mobileNum,
            dataType : 'text',
            cache : false,
            error : function() {
                alert('出错了！');
                return false;
            },

            success : function(data) {
                if(data == "false"){
                    alert("phone exist");
                    //号码存在时重定向
                    window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx177b9a3366b821e8&redirect_uri=http%3a%2f%2ffb2a86b8.ngrok.io%2fgoToCJ&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
                }
            }
        });
    }
    else{
        window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx177b9a3366b821e8&redirect_uri=http%3a%2f%2ffb2a86b8.ngrok.io%2fgoToCJ&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
    }


    $("#inner").click(function() {
        lottery();
    });
});


//抽奖程序
function lottery() {
    $.ajax({
        type : 'POST',
        url : 'awardServlet',
        dataType : 'json',
        cache : false,
        error : function() {
            alert('出错了！');
            return false;
        },

        success : function(json) {
            $("#inner").unbind('click').css("cursor", "default");
            var angle = parseInt(json.angle); //角度
            var msg = json.msg; //提示信息
            $("#outer").rotate({ //inner内部指针转动，outer外部转盘转动
                duration : 5000, //转动时间
                angle : 0, //开始角度
                animateTo : 3600 + angle, //转动角度
                easing : $.easing.easeOutSine, //动画扩展
                callback : function() {
                    //抽奖成功提示成功消息并跳转到结果页面
                    alert(msg);
                    //推送中奖消息
                    $.ajax({
                        type : 'GET',
                        url : 'pushToUserServlet',
                        dataType : 'text',
                        cache : false,
                        error : function() {
                            alert('推送失败！');
                            return false;
                        },

                        success : function(data) {
                            alert("成功推送消息");
                        }
                    });

                    window.location.href="result.html";


                }
            });
        }
    });
}