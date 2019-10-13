<!-- EDIT modal-->

$(document).ready(function(){
    $('.dropdown .eBtn').on('click', function(event){
        //prevents redirection to blank page with JSON-Task-Object
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(task){
            $('.myForm #id').val(task.id);
            $('.myForm #title').val(task.title);
            $('.myForm #content').val(task.content);
            $('.myForm #status').val(task.status);
        });
        $('.myForm #editModal').modal();
    });
});

<!--NEW Task Modal-->

$(document).ready(function(){
    $('.newBtn').on('click', function(event){

        //prevents redirection to blank page with JSON-Task-Object
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(work){
            $('.work_name #optionId').val(work.description);
            // $('.myForm #title').val(task.title);
            // $('.myForm #content').val(task.content);
            // $('.myForm #status').val(task.status);
        });
        // $.get(href, function(modalActions){
        //     for (let i = 0; i < modalActions.size(); i++) {
        //         $('.myForm #description').val(modalActions.get(i).description);
        //         $('.myForm #actionsPerWeek').val(modalActions.get(i).actionsPerWeek);
        //         $('.myForm #weekCounter').val(modalActions.get(i).weekCounter);
        //
        //     }
        //     // $('.myForm #id').val(task.id);
        //     // $('.myForm #title').val(task.title);
        //     // $('.myForm #content').val(task.content);
        //     // $('.myForm #status').val(task.status);
        // });

        // $('.newTaskForm #id').val('');
        // $('.newTaskForm #title').val('');
        // $('.newTaskForm #content').val('');
        // $('.newTaskForm #status').val('OPEN');
        // $('.newTaskForm #newTaskModal').modal();
    });
});

<!--Datatable-->

const dataTable = $('#realtime').DataTable({
    data: actionList,
    columns: [
        { data: 'Услуга' },
        { data: 'Сколько раз в неделю' },
        { data: 'На какой период' },
        { data: 'Удалить услугу' }
    ]
});



var ajaxUrl = "ajax/profile/meals/";
var datatableApi;

function updateTable() {
    $.ajax({
        type: "POST",
        url: ajaxUrl + "filter",
        data: $("#filter").serialize(),
        success: updateTableByData
    });
}

function clearFilter() {
    $("#filter")[0].reset();
    $.get(ajaxUrl, updateTableByData);
}

$(function () {
    datatableApi = $("#datatable").DataTable({
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "description"
            },
            {
                "data": "actionsPerWeek"
            },
            {
                "data": "weekCounter"
            },
            {
                "defaultContent": "Delete",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ]
    });
    makeEditable();
});

function makeEditable() {
    form = $('#modalActionsForm');
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
    });

    // solve problem with cache in IE: https://stackoverflow.com/a/4303862/548473
    $.ajaxSetup({cache: false});
}

