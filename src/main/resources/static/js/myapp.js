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
        // $('.newTaskForm #id').val('');
        // $('.newTaskForm #title').val('');
        // $('.newTaskForm #content').val('');
        // $('.newTaskForm #status').val('OPEN');
        // $('.newTaskForm #newTaskModal').modal();
    });
});

