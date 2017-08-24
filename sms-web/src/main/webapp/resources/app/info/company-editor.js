var introduceEditor, missionEditor, strategyEditor, teamSpiritEditor;
$(function () {
    introduceEditor = UE.getEditor('introduce', {
        toolbars: [
            [
                'fontfamily', //字体
                'fontsize', //字号
                'paragraph', //段落格式
                'justifyleft', //居左对齐
                'justifyright', //居右对齐
                'justifycenter', //居中对齐
                'justifyjustify', //两端对齐
                'forecolor', //字体颜色
                'undo', //撤销
                'redo', //重做
                'bold', //加粗
                'indent', //首行缩进
                //'snapscreen', //截图
                'italic', //斜体
                'underline', //下划线
                'strikethrough', //删除线
                'subscript', //下标
                'fontborder', //字符边框
                'superscript', //上标
                'formatmatch', //格式刷
                'anchor', //锚点
                'source', //源代码
                'blockquote', //引用
                'pasteplain', //纯文本粘贴模式
                'selectall', //全选
                //'print', //打印
                'horizontal', //分隔线
                'removeformat', //清除格式
                'time', //时间
                'date', //日期
                'unlink', //取消链接
                //'insertrow', //前插入行
                //'insertcol', //前插入列
                //'mergeright', //右合并单元格
                //'mergedown', //下合并单元格
                //'deleterow', //删除行
                //'deletecol', //删除列
                //'splittorows', //拆分成行
                //'splittocols', //拆分成列
                //'splittocells', //完全拆分单元格
                //'deletecaption', //删除表格标题
                'inserttitle', //插入标题
                //'mergecells', //合并多个单元格
                //'deletetable', //删除表格
                'cleardoc', //清空文档
                //'insertparagraphbeforetable', //"表格前插入行"
                //'insertcode', //代码语言
                'simpleupload', //单图上传
                'insertimage', //多图上传
                //'edittable', //表格属性
                //'edittd', //单元格属性
                'link', //超链接
                //'emotion', //表情
                'spechars', //特殊字符
                'searchreplace', //查询替换
                //'map', //Baidu地图
                //'gmap', //Google地图
                //'insertvideo', //视频
                'backcolor', //背景色
                'insertorderedlist', //有序列表
                'insertunorderedlist', //无序列表
                'fullscreen', //全屏
                'directionalityltr', //从左向右输入
                'directionalityrtl', //从右向左输入
                'rowspacingtop', //段前距
                'rowspacingbottom', //段后距
                //'pagebreak', //分页
                //'insertframe', //插入Iframe
                //'imagenone', //默认
                //'imageleft', //左浮动
                //'imageright', //右浮动
                'attachment', //附件
                'imagecenter', //居中
                'wordimage', //图片转存
                'lineheight', //行间距
                'edittip ', //编辑提示
                //'customstyle', //自定义标题
                'autotypeset', //自动排版
                //'webapp', //百度应用
                //'touppercase', //字母大写
                //'tolowercase', //字母小写
                //'background', //背景
                //'template', //模板
                //'scrawl', //涂鸦
                //'music', //音乐
                //'inserttable', //插入表格
                //'drafts', // 从草稿箱加载
                //'charts', // 图表
                'preview', //预览
                'help', //帮助
            ]
        ]
    });
    missionEditor = UE.getEditor('mission', {
        toolbars: [
            [
                'fontfamily', //字体
                'fontsize', //字号
                'paragraph', //段落格式
                'justifyleft', //居左对齐
                'justifyright', //居右对齐
                'justifycenter', //居中对齐
                'justifyjustify', //两端对齐
                'forecolor', //字体颜色
                'undo', //撤销
                'redo', //重做
                'bold', //加粗
                'indent', //首行缩进
                //'snapscreen', //截图
                'italic', //斜体
                'underline', //下划线
                'strikethrough', //删除线
                'subscript', //下标
                'fontborder', //字符边框
                'superscript', //上标
                'formatmatch', //格式刷
                'anchor', //锚点
                //'source', //源代码
                'blockquote', //引用
                'pasteplain', //纯文本粘贴模式
                'selectall', //全选
                //'print', //打印
                'horizontal', //分隔线
                'removeformat', //清除格式
                'time', //时间
                'date', //日期
                'unlink', //取消链接
                //'insertrow', //前插入行
                //'insertcol', //前插入列
                //'mergeright', //右合并单元格
                //'mergedown', //下合并单元格
                //'deleterow', //删除行
                //'deletecol', //删除列
                //'splittorows', //拆分成行
                //'splittocols', //拆分成列
                //'splittocells', //完全拆分单元格
                //'deletecaption', //删除表格标题
                'inserttitle', //插入标题
                //'mergecells', //合并多个单元格
                //'deletetable', //删除表格
                'cleardoc', //清空文档
                //'insertparagraphbeforetable', //"表格前插入行"
                //'insertcode', //代码语言
                'simpleupload', //单图上传
                'insertimage', //多图上传
                //'edittable', //表格属性
                //'edittd', //单元格属性
                'link', //超链接
                //'emotion', //表情
                'spechars', //特殊字符
                'searchreplace', //查询替换
                //'map', //Baidu地图
                //'gmap', //Google地图
                //'insertvideo', //视频
                'backcolor', //背景色
                'insertorderedlist', //有序列表
                'insertunorderedlist', //无序列表
                'fullscreen', //全屏
                'directionalityltr', //从左向右输入
                'directionalityrtl', //从右向左输入
                'rowspacingtop', //段前距
                'rowspacingbottom', //段后距
                //'pagebreak', //分页
                //'insertframe', //插入Iframe
                //'imagenone', //默认
                //'imageleft', //左浮动
                //'imageright', //右浮动
                'attachment', //附件
                'imagecenter', //居中
                'wordimage', //图片转存
                'lineheight', //行间距
                'edittip ', //编辑提示
                //'customstyle', //自定义标题
                'autotypeset', //自动排版
                //'webapp', //百度应用
                //'touppercase', //字母大写
                //'tolowercase', //字母小写
                //'background', //背景
                //'template', //模板
                //'scrawl', //涂鸦
                //'music', //音乐
                //'inserttable', //插入表格
                //'drafts', // 从草稿箱加载
                //'charts', // 图表
                'preview', //预览
                'help', //帮助
            ]
        ]
    });
    strategyEditor = UE.getEditor('strategy', {
        toolbars: [
            [
                'fontfamily', //字体
                'fontsize', //字号
                'paragraph', //段落格式
                'justifyleft', //居左对齐
                'justifyright', //居右对齐
                'justifycenter', //居中对齐
                'justifyjustify', //两端对齐
                'forecolor', //字体颜色
                'undo', //撤销
                'redo', //重做
                'bold', //加粗
                'indent', //首行缩进
                //'snapscreen', //截图
                'italic', //斜体
                'underline', //下划线
                'strikethrough', //删除线
                'subscript', //下标
                'fontborder', //字符边框
                'superscript', //上标
                'formatmatch', //格式刷
                'anchor', //锚点
                //'source', //源代码
                'blockquote', //引用
                'pasteplain', //纯文本粘贴模式
                'selectall', //全选
                //'print', //打印
                'horizontal', //分隔线
                'removeformat', //清除格式
                'time', //时间
                'date', //日期
                'unlink', //取消链接
                //'insertrow', //前插入行
                //'insertcol', //前插入列
                //'mergeright', //右合并单元格
                //'mergedown', //下合并单元格
                //'deleterow', //删除行
                //'deletecol', //删除列
                //'splittorows', //拆分成行
                //'splittocols', //拆分成列
                //'splittocells', //完全拆分单元格
                //'deletecaption', //删除表格标题
                'inserttitle', //插入标题
                //'mergecells', //合并多个单元格
                //'deletetable', //删除表格
                'cleardoc', //清空文档
                //'insertparagraphbeforetable', //"表格前插入行"
                //'insertcode', //代码语言
                'simpleupload', //单图上传
                'insertimage', //多图上传
                //'edittable', //表格属性
                //'edittd', //单元格属性
                'link', //超链接
                //'emotion', //表情
                'spechars', //特殊字符
                'searchreplace', //查询替换
                //'map', //Baidu地图
                //'gmap', //Google地图
                //'insertvideo', //视频
                'backcolor', //背景色
                'insertorderedlist', //有序列表
                'insertunorderedlist', //无序列表
                'fullscreen', //全屏
                'directionalityltr', //从左向右输入
                'directionalityrtl', //从右向左输入
                'rowspacingtop', //段前距
                'rowspacingbottom', //段后距
                //'pagebreak', //分页
                //'insertframe', //插入Iframe
                //'imagenone', //默认
                //'imageleft', //左浮动
                //'imageright', //右浮动
                'attachment', //附件
                'imagecenter', //居中
                'wordimage', //图片转存
                'lineheight', //行间距
                'edittip ', //编辑提示
                //'customstyle', //自定义标题
                'autotypeset', //自动排版
                //'webapp', //百度应用
                //'touppercase', //字母大写
                //'tolowercase', //字母小写
                //'background', //背景
                //'template', //模板
                //'scrawl', //涂鸦
                //'music', //音乐
                //'inserttable', //插入表格
                //'drafts', // 从草稿箱加载
                //'charts', // 图表
                'preview', //预览
                'help', //帮助
            ]
        ]
    });
    teamSpiritEditor = UE.getEditor('teamSpirit', {
        toolbars: [
            [
                'fontfamily', //字体
                'fontsize', //字号
                'paragraph', //段落格式
                'justifyleft', //居左对齐
                'justifyright', //居右对齐
                'justifycenter', //居中对齐
                'justifyjustify', //两端对齐
                'forecolor', //字体颜色
                'undo', //撤销
                'redo', //重做
                'bold', //加粗
                'indent', //首行缩进
                //'snapscreen', //截图
                'italic', //斜体
                'underline', //下划线
                'strikethrough', //删除线
                'subscript', //下标
                'fontborder', //字符边框
                'superscript', //上标
                'formatmatch', //格式刷
                'anchor', //锚点
                //'source', //源代码
                'blockquote', //引用
                'pasteplain', //纯文本粘贴模式
                'selectall', //全选
                //'print', //打印
                'horizontal', //分隔线
                'removeformat', //清除格式
                'time', //时间
                'date', //日期
                'unlink', //取消链接
                //'insertrow', //前插入行
                //'insertcol', //前插入列
                //'mergeright', //右合并单元格
                //'mergedown', //下合并单元格
                //'deleterow', //删除行
                //'deletecol', //删除列
                //'splittorows', //拆分成行
                //'splittocols', //拆分成列
                //'splittocells', //完全拆分单元格
                //'deletecaption', //删除表格标题
                'inserttitle', //插入标题
                //'mergecells', //合并多个单元格
                //'deletetable', //删除表格
                'cleardoc', //清空文档
                //'insertparagraphbeforetable', //"表格前插入行"
                //'insertcode', //代码语言
                'simpleupload', //单图上传
                'insertimage', //多图上传
                //'edittable', //表格属性
                //'edittd', //单元格属性
                'link', //超链接
                //'emotion', //表情
                'spechars', //特殊字符
                'searchreplace', //查询替换
                //'map', //Baidu地图
                //'gmap', //Google地图
                //'insertvideo', //视频
                'backcolor', //背景色
                'insertorderedlist', //有序列表
                'insertunorderedlist', //无序列表
                'fullscreen', //全屏
                'directionalityltr', //从左向右输入
                'directionalityrtl', //从右向左输入
                'rowspacingtop', //段前距
                'rowspacingbottom', //段后距
                //'pagebreak', //分页
                //'insertframe', //插入Iframe
                //'imagenone', //默认
                //'imageleft', //左浮动
                //'imageright', //右浮动
                'attachment', //附件
                'imagecenter', //居中
                'wordimage', //图片转存
                'lineheight', //行间距
                'edittip ', //编辑提示
                //'customstyle', //自定义标题
                'autotypeset', //自动排版
                //'webapp', //百度应用
                //'touppercase', //字母大写
                //'tolowercase', //字母小写
                //'background', //背景
                //'template', //模板
                //'scrawl', //涂鸦
                //'music', //音乐
                //'inserttable', //插入表格
                //'drafts', // 从草稿箱加载
                //'charts', // 图表
                'preview', //预览
                'help', //帮助
            ]
        ]
    });
    var count = 0;
    var validate = $(formObj).submit(function() {
        UE.getEditor('introduce').sync();
        UE.getEditor('mission').sync();
        UE.getEditor('strategy').sync();
        UE.getEditor('teamSpirit').sync();
    }).validate({
        ignore: "",
        errorElement: 'div',
        errorClass: 'help-block',
        focusInvalid: true,
        rules: {
            name: {required: true},
            hotLine: {required: true},
            workTime: {required: true},
            logo: {required: true},
            introduce: {required: true},
            mission: {required: true},
            strategy: {required: true},
            teamSpirit: {required: true}
        },
        messages: {
            name: {required: "公司名称不能为空."},
            hotLine: {required: "公司服务热线不能为空."},
            workTime: {required: "公司服务工作时间不能为空."},
            logo: {required: "公司logo不能为空."},
            introduce: {required: "公司介绍不能为空."},
            mission: {required: "公司使命不能为空."},
            strategy: {required: "公司愿景不能为空."},
            teamSpirit: {required: "团队精神不能为空."}
        },

        invalidHandler: function (event, validator) { //display error alert on form submit
            $('.alert-danger', $('.company-form')).show();
        },
        highlight: function (e) {
            $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
        },
        success: function (e) {
            $(e).closest('.form-group').removeClass('has-error').addClass('has-info');
            $(e).remove();
        },
        errorPlacement: function (error, element) {
            if (element.is(':checkbox') || element.is(':radio')) {
                var controls = element.closest('div[class*="col-"]');
                if (controls.find(':checkbox,:radio').length > 1) controls.append(error);
                else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
            }
            else if (element.is('.select2')) {
                error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
            }
            else if (element.is('.chosen-select')) {
                error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
            } else if(element.is('textarea')){
                element.parent().append(error);
            }
            else {
                error.insertAfter(element.parent());
            }
        },
        submitHandler: function (form) {
        },
        invalidHandler: function (form) {
        }
    });
    validate.focusInvalid = function() {
        if( this.settings.focusInvalid ) {
            try {
                var toFocus = $(this.findLastActive() || this.errorList.length && this.errorList[0].element || []);
                if (toFocus.is("textarea")) {
                    UE.getEditor('introduce').focus()
                } else {
                    toFocus.filter(":visible").focus();
                }
            } catch(e) {
            }
        }
    }
});