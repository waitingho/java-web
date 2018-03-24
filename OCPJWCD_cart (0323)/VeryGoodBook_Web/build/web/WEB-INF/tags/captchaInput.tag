<%@tag description="驗證碼輸入項" pageEncoding="UTF-8"%>
<%@attribute name="src" required="true" %>
<%@attribute name="name" %>
    <input type='text' name='${empty name?"captcha":name}' placeholder="請輸入驗證碼" required><br>
    <a href="javascript:refreshCaptcha()">
        <img id="${empty name?"captcha":name}_img" title="點選即可更新圖片" src='${src}' style="vertical-align: middle">
    </a>
    <script>
        function refreshCaptcha() {
            //$("#${empty name?"captcha":name}_img").attr("src", "${src}?refresh=" + new Date());
            var captcha_img = document.getElementById("${empty name?"captcha":name}_img");
            captcha_img.src = "${src}?refresh=" + new Date();
        }
    </script>