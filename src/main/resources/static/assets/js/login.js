$("form").submit(function(e){
    e.preventDefault();
    var account=$("#account").val();
    var password=$("#password").val();
    if (account=="admin"&&password=="123456")
    {
        alert("登录成功");
        location.href = "admin-table.html";
    }
    else {
        alert("账号或密码错误");
    }
});