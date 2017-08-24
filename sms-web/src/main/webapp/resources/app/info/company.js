/**
 * Created by huxinsheng on 2017/3/7.
 */
var tabTemplate = "<li><a href='#{href}'>#{label}<span class='icon-remove-sign' role='presentation'></span></li></a> ",
    tabCounter = 2;
var tabs;
$(function () {
    tabs = $("#tabs").tabs();

    tabs.on("click", "span.icon-remove-sign", function () {
        var panelId = $(this).closest("li").remove().attr("aria-controls");
        $("#" + panelId).remove();
        tabs.tabs("refresh");
    });

    tabs.on("keyup", function (event) {
        if (event.altKey && event.keyCode === $.ui.keyCode.BACKSPACE) {
            var panelId = tabs.find(".ui-tabs-active").remove().attr("aria-controls");
            $("#" + panelId).remove();
            tabs.tabs("refresh");
        }
    });
    $("#file-0").fileinput({
        showUpload: false,
        showCaption: false,
        browseClass: "btn btn-primary btn-lg",
        fileType: "any",
        previewFileIcon: "<i class='icon-folder-open'></i>"
    });
});
// Actual addTab function: adds new tab using the input from the form above
function addTab() {
    var label = "测试" || "Tab" + tabCounter,
        id = "tabs-" + tabCounter,
        li = $(tabTemplate.replace(/#\{href\}/g, "#" + id).replace(/#\{label\}/g, label)),
        tabContentHtml = "测试数据" || "Tab " + tabCounter + " content.";
    console.info(label);
    tabs.find(".ui-tabs-nav").append(li);
    tabs.append("<div id='" + id + "'><p>" + tabContentHtml + "</p></div>");
    tabs.tabs("refresh");
    tabCounter++;
}