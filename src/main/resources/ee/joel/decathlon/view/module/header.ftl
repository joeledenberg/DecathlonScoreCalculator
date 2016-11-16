<#ftl encoding="utf-8">
<!DOCTYPE html>
<html>
<head>
    <title>Decathlon Score Calculator</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700|Source+Sans+Pro:300,400&subset=latin-ext" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            text-align: center;
            max-width: 700px;
            margin:auto;
        }
        h1 {
            font-size: 52px;
            font-weight: 100;
        }
        #warning {
            color: #e75400;
            font-weight: 300;
            font-size: 19px;
        }
        #calculatedScore {
            font-size: 62px;
            color: #4ea715;
        }
        .results {
            display:block;
            height:200px;
        }
        input, select {
            font-size: 32px;
            text-align: center;
        }
    </style>
