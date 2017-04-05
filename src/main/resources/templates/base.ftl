<#assign base = request.contextPath />
<!DOCTYPE html>
<html >
<head>
<@block name="head">base_head_content</@block>
</head>
<body>
<@block name="body">中国${base} </@block>
</body>
</html>