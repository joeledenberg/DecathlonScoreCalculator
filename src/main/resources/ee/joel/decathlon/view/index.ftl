<#ftl encoding="utf-8">
<#include "module/header.ftl" parse=true>

<h1>Decathlon score calculator</h1>
<div class="results">
    <h2 id="calculatedScore"></h2>
    <h2 id="warning"></h2>
</div>

<form action="/decathlon" id="decathlonCalculator">
    <select id="event">
    <#list events as event>
        <option value="${event.toString()}">${event.getName()}</option >
    </#list>
    </select>
    <input type="text" name="value" id="value"><br>
    <input type="submit" value="Submit">
</form>

<script src="/staatiline/js/function.js"></script>
<#include "module/footer.ftl" parse=true>