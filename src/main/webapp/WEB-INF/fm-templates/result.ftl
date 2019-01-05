<html>
<head>
    <meta charset="UTF-8">
    <title>Fibonacci</title>
    <!-- Bootstrap core CSS -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="jumbotron">

        <#if errorsMap??>
            <div class="p-3 mb-2 bg-danger text-white">${errorsMap['error']}</div>
        <#else>

            <h2>Element ${n} wynosi: ${result}</h2>
            <hr class="my-4">
            <a class="btn btn-primary" href="../../index.html">Sprawdź kolejny element</a>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Nr Elementu</th>
                    <th scope="col">Wartość</th>
                </tr>
                </thead>
                <tbody>

                <#list list as l>
                    <#if l_index gt 0 >
                        <tr>
                            <td>${l_index}</td>
                            <td>${l}</td>
                        </tr>
                    </#if>
                </#list>

                </tbody>
            </table>
        </#if>
    </div>
</div>

<script src="../../js/jquery-3.3.1.slim.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
</body>
</html>