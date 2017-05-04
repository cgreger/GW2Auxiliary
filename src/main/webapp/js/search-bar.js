$(document).ready(function() {


    $("#search").keyup(function() {

        var search_path = $(location).attr("href") + "/../process_search";

        var query = $("#search").val();

        $.ajax({url: search_path, data: {"query" : query}, success: function(results){

            $.each(results, function(name, ))

        }});
    })
});