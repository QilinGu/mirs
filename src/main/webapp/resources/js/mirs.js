//业务逻辑代码

var mirs = {

    // 接口
    URL : {
        oAuthUrl: function (type) {
            return '/oauth/' + type;
        },
        loginUrl: function () {
            return '/accounts/login';
        },
        registerUrl: function () {
            return '/accounts/register';
        },
        getCaptchaUrl: function () {
            return '/captcha/get';
        },
        checkCaptchaUrl: function (captcha) {
            return '/captcha/check/' + captcha;
        },
        checkUserEmailUrl: function (email) {
            return '/inspection/userEmail?email=' + email;
        },
        checkUserNameUrl: function (name) {
            return '/inspection/userName?name=' + name;
        },
        checkVerificationUrl: function (verification) {
            return '/inspection/verification?verification=' + verification;
        }

    },

    loadOAuthUrl: function (element, oauthUrl) {
        $.post(oauthUrl, {}, function (result) {
            if(result && result['success']) {
                console.log(result['data']['url']);
                $(element).attr("href", result['data']['url']);
            }
        })
    },

    changeCaptcha: function (element) {
        $(element).hide().attr('src', this.URL.getCaptchaUrl() + '?' + Math.floor(Math.random()*100) ).fadeIn();
    },

    checkStatus: function (element, checkUrl, statusElement) {
        $.post(checkUrl, {}, function (result) {
            if(result && result['success']) {
                $(statusElement).html("<span style='color: green'>√</span>");
            } else {
                $(statusElement).html(result['error']);
            }
        })
    },
    

}