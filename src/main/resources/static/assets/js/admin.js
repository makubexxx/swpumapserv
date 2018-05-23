$(document).ready(function(){
    $.getJSON("/lvqinglong/v1/student/findall",function(result){
        $.each(result.body, function(i, item){
            $("#table").append("   <tr>\n" +
                "                <td><input type=\"checkbox\" /></td>\n" +
                "                <td>1</td>\n" +
                "                <td><a href=\"#\">"+item.studentno+"</a></td>\n" +
                "                <td>"+item.is_bind+"</td>\n" +
                "                </td>\n" +
                "              </tr>");
        });
    });
});


    $('#doc-prompt-toggle').on('click', function() {
        $('#my-prompt').modal({
            relatedTarget: this,
            onConfirm: function(e) {
                $.ajax({
                    type: "post",
                    url: "/lvqinglong/v1/student/add",
                    data: {account:e.data }, //可选参数
                    success: function (data) {
                        alert("添加成功");

                    } //可选参数
                });
            },
            onCancel: function(e) {
            }
        });
    });