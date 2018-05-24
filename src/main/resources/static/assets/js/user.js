$(document).ready(function(){
    var account =getQueryString("account");
    $("#doc-prompt-toggle").append(account+"->定位记录")
    $.getJSON("/lvqinglong/v1/location/findall?account="+account,function(result){
        $.each(result.body, function(i, item){
            $("#table").append("   <tr>\n" +
                "                <td><input type=\"checkbox\" /></td>\n" +
                "                <td>1</td>\n" +
                "                <td>"+item.id+"</td>\n" +
                "                <td>"+item.latitude+"</td>\n" +
                "                <td>"+item.longitude+"</td>\n" +
                "                <td>"+item.location_desc+"</td>\n" +
                "                <td>"+item.collect_date+"</td>\n" +
                "                </td>\n" +
                "              </tr>");
        });
    });
});
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}