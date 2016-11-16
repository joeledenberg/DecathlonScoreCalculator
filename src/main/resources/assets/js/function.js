$("#decathlonCalculator").submit(function(event){
    var data = {
        event: $("#event").val(),
        result: $("#value").val()
    };
    $.ajax({
        type: "POST",
        url: "/decathlon",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function(response) {
        $("#calculatedScore").html(response.score)
        if (response.warning) {
            $("#warning").html(response.warning)
        } else {
            $("#warning").html("");
        }
    })
        .fail(function(response) {
            $("#calculatedScore").html("-");
            $("#warning").html(response.responseJSON.details);
        });
    event.preventDefault();
})