$(function () {
    initLeftMenu();
    $('.personal-config').on('click', function () {
        console.info('设置');
    });
    $('.personal-profile').on('click', function () {
        console.info('个人资料');
    })
});

//初始化左侧
function initLeftMenu() {
    $.getJSON("/resources/data/menu.json", function (result) {
        var pathName = window.location.pathname;
        var html = '<li class="' + (pathName === '/' ? "active" : "") + '">';
        html += '   <a href="/">';
        html += '       <i class="fa fa-home"></i>';
        html += '       <span class="menu-text"> 系统首页 </span>';
        html += '   </a>';
        html += '   <b class="arrow"></b>';
        html += '</li>';
        $('.nav-list').append($(html));
        $.each(result, function (i, item) {
            html = '<li class="">                                     ';
            html += '	<a href="#" class="dropdown-toggle">             ';
            html += '		<i class="' + item.icon + '"></i>           ';
            html += '		<span class="menu-text"> ' + item.name + ' </span>        ';
            html += '		<b class="arrow fa fa-angle-down"></b>         ';
            html += '	</a>                                             ';
            html += '	<b class="arrow"></b>                            ';
            html += '	<ul class="submenu">                             ';

            html += '	</ul>                                            ';
            html += '</li>                                             ';

            var parent = $(html);
            if (item.childMenu && item.childMenu.length > 0) {
                html = '';
                $.each(item.childMenu, function (j, subItem) {
                    if (pathName === subItem.url) {
                        html += '		<li class="active">';
                        $(parent).addClass('active open');
                        $('.breadcrumb').append('<li>' + item.name + '</li>').append('<li>' + subItem.name + '</li>');
                    } else {
                        html += '		<li class="">';
                    }
                    if (subItem.url.indexOf('druid') !== -1) {
                        html += '			<a href="' + subItem.url + '" target="_blank">';
                    } else {
                        html += '			<a href="' + subItem.url + '">';
                    }
                    html += '				<i class="menu-icon fa fa-caret-right"></i>';
                    html += subItem.name;
                    html += '			</a>';
                    html += '			<b class="arrow"></b>';
                    html += '		</li>';
                });
                parent.find('.submenu').append($(html))
            }
            $('.nav-list').append(parent);
        });
    });
}

