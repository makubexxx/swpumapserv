$(document).ready(function(){
    $.getJSON("/lvqinglong/v1/student/findall",function(result){
        $.each(result.body, function(i, item){
            $("#table").append("   <tr>\n" +
                "                <td><input type=\"checkbox\" /></td>\n" +
                "                <td>1</td>\n" +
                "                <td>"+item.studentno+"</td>\n" +
                "                <td>"+item.is_bindstr+"</td>\n" +
                "                <td><a href='user-table.html?account="+item.account+"'>"+item.account+"</a></td>\n" +
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
                    location.reload();
                } //可选参数
            });
        },
        onCancel: function(e) {
        }
    });
});