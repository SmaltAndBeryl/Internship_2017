var thisIsResponse;
function responseOfUpload(thisIsResponse)
{
	var x = document.getElementById("responseOfUpload");
	console.log(thisIsResponse);
	if(thisIsResponse == 'Data Successfully inserted in Database')
        {
            x.style.color = '#1AB394';
        }
        
	else
        {
            x.style.color = "red";
        }
    var array = thisIsResponse.split(".");
	console.log(array);
	x.innerHTML = array.join(" <br />");
}
function csvFileName($scope)
{
    var fileName=document.getElementById("csvFileName").value;
    var fileExtension = fileName.split('.').pop();
        if (fileName==null || fileName=="" || fileExtension!='csv')
        {
            document.getElementById("csvFileName").style.borderColor = "red";
            return false;
        }
        else return true;
}
$(document).on('click', '.browse', function()
{
    var file = $(this).parent().parent().parent().find('.file');
    file.trigger('click');
});
$(document).on('change', '.file', function()
{
    $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, ''));
});

