
function isnull(name,password,flag) {

    var str1 = name.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
    var str2 = password.replace(/(^\s*)|(\s*$)/g, '');
    if (str1 == '' || str1 == undefined || str1 == null||str2 == '' || str2 == undefined || str2 == null) {
        //return true;
        if(flag==1){
        alert('请输入账号密码');
        } else{
            alert("请输入旧密码与新密码");
        }
    } else {
        //return false;
        //alert('非空');
    }
}