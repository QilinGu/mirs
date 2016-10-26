//业务逻辑代码

var mirs = {

    // 接口
    URL : {
        oAuthUrl: function (type) {
            return '/oauth/' + type;
        },
        loginUrl: function () {
            return '/login';
        },
        registerUrl: function () {
            return '/register';
        },
        getCaptchaUrl: function () {
            return '/captcha/get';
        },
        checkCaptchaUrl: function () {
            return '/captcha/check';
        },

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

    checkCaptcha: function (element, status) {
        $.post(this.URL.checkCaptchaUrl() + '?captcha=' + $(element).val(), {}, function (result) {
            if(result && result['success']) {
                $(status).html("√");
            } else {
                $(status).html(result['error']);
            }
        })
    }

}