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
        checkUseremailUrl: function (email) {
            return '/inspection/userEmail?email=';
        },
        checkUsernameUrl: function (name) {
            return '/inspection/userName?name=';
        },
        checkVerificationUrl: function (verification) {
            return '/inspection/verification?verification=';
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

    checkCaptcha: function (element, status) {
        $.post(this.URL.checkCaptchaUrl($(element).val()), {}, function (result) {
            if(result && result['success']) {
                $(status).html("<span style='color: green'>√</span>");
            } else {
                $(status).html(result['error']);
            }
        })
    },

    checkUseremail: function (element, status) {
        $.post(this.URL.checkUseremailUrl($(element).val()), {}, function (result) {
            if(result && result['success']) {
                $(status).html("<span style='color: green'>√</span>");
            } else {
                $(status).html(result['error']);
            }
        })
    },
    checkUsername: function (element, status) {
        $.post(this.URL.checkUsernameUrl($(element).val()), {}, function (result) {
            if(result && result['success']) {
                $(status).html("<span style='color: green'>√</span>");
            } else {
                $(status).html(result['error']);
            }
        })
    },
    checkVerification: function (element, status) {
        $.post(this.URL.checkVerificationUrl($(element).val()), {}, function (result) {
            if(result && result['success']) {
                $(status).html("<span style='color: green'>√</span>");
            } else {
                $(status).html(result['error']);
            }
        })
    }

}