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
        },
        dailyMovieUrl: function () {
            return '/movie/daily';
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

    checkStatus: function (element, checkUrl, statusElement,id) {
        $.post(checkUrl, {}, function (result) {
            if(result && result['success']) {
                $(statusElement).html("<span style='color: green'>√</span>");
                $(id).removeAttr("disabled");
            } else {
                $(statusElement).html(result['error']);
            }
        })
    },

    getDailyMovie: function(statusElement,id) {
        $.get(this.URL.dailyMovieUrl(), {}, function (result) {
            if(result && result['success']) {
                var movies = result['data'];
                var parent = document.getElementById(statusElement);
                for(var i = 0; i < movies.length; i++) {
                    console.log(movies[i]['name']);
                    var div = '<div style="width: 300px;height: 600px;background-color: #1F811F;float: left"><img src="'+movies[i]['coverLink']+'"></img>' +movies[i]['name']+ '</div>';
                    $(statusElement).append(div);
                }
            } else {

            }
        })
    }

}