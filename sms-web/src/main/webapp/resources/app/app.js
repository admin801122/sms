var default_opts = {
    lines: 10, // 条状数目
    length: 15, // 条状长度
    width: 7, // 条状宽度
    radius: 10, // 条状中心的半径
    corners: 1, // 条状的圆滑度(0..1)
    rotate: 0, // 条状旋转的角度
    direction: 1, // 条状旋转的速度
    color: '#000', //颜色
    speed: 1, // 条状旋转的速度
    trail: 60, // Afterglow percentage
    shadow: false, // Whether to render a shadow
    hwaccel: false, // Whether to use hardware acceleration
    className: 'spinner', // The CSS class to assign to the spinner
    zIndex: 5, // The z-index (defaults to 2000000000)
    top: '200px', // Top position relative to parent in px    //200PX
    left: 'auto' // Left position relative to parent in px
};
$.ajaxSetup({
    contentType: "application/x-www-form-urlencoded;charset=utf-8",
    complete: function (XMLHttpRequest, textStatus) {
        var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
        //通过XMLHttpRequest取得响应头，sessionstatus，
        if (sessionstatus == "timeout") {
            //如果超时就处理 ，指定要跳转的页面
            window.parent.location.replace(ctx + "/login");
        }
    }
});
/*var _spin = new Spinner(default_opts);*/
//页面提示
function showPageTips(style, message) {
    if (!message) {
        message = style;
        style = 'success';
    }
    var el = $('<div class="alert alert-' + style + '">' + message + '</div>');
    $('body').append(el);
    el.css({
        'position': 'fixed',
        'z-index': '10000',
        'top': '0',
        'left': '50%',
        'margin-top': '0px',
        'min-width': '300px',
        'margin-left': function () {
            return -$(this).width() / 2;
        },
        'text-align': 'center',
        'padding': '12px'
    });
    el.animate({
        'opacity': 0
    }, 6000);
}

//页面提示
function showSuccessTips(message) {
    showPageTips('success', message);
}

//页面提示
function showWarningTips(message) {
    showPageTips('warning', message);
}

//页面提示
function showErrorTips(message) {
    showPageTips('danger', message);
}
/**
 * 显示模式对话框
 * @param dialog 对话框dom元素，可以是class名，也可以id
 * @param title 对话框标题
 * @param validate  form验证对象
 * @param form form对象
 * @param formData form数据，可为空
 */
function showDialog(dialog, title, validate, form, formData) {
    if (!formData)
        formData = {};
    $(form + ' .form-group').removeClass('has-error');
    validate.resetForm();
    $(form)[0].reset();
    $(form).initForm({jsonValue: formData, isDebug: false});
    $(dialog + ' .modal-title').html(title);
    /* 完成拖拽 */
    $(dialog).draggable({
        cursor: "move",
        handle: '.modal-header'
    });
    $(dialog).modal('show');

}
/**
 * 显示模式对话框
 * @param divEl 编辑divdom元素，可以是class名，也可以id
 * @param title 编辑div的标题
 * @param validate  form验证对象
 * @param form form对象
 * @param formData form数据，可为空
 */
function showEditDiv(divEl, title, validate, form, formData) {
    if (!formData)
        formData = {};
    $(form + ' .form-group').removeClass('has-error');
    validate.resetForm();
    $(divEl + ' .page-header h1').html(title);
    $(form)[0].reset();
    $(form).initForm({jsonValue: formData, isDebug: false});
    $(divEl).show();

}
$(function () {
    $('.bootbox-close-button').on('click', function () {
        $('.bootbox input[type=checkbox]:checked').each(function () {
            $(this).attr('checked', false);
        });
        $('.bootbox').modal('hide');
        cleanTree();
    });
});
function cleanTree() {
    $('.bootbox input[type=checkbox]:checked').each(function () {
        $(this).attr('checked', false);
    });
    $('.tree').removeData("fu.tree");
    //清空事件
    $('.tree').unbind('click');
}