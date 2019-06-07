// console.log("Connected to the static javascript file");

// $(document).on("click", "#upDater", function(){

//     var id = $("#disId").val().trim();
//     var title = $("#title").val().trim();
//     var author = $("#author").val().trim();
//     var postBody = $("#postBody").val().trim();
//     console.log(id);

//     console.log("This post: \n" + id + " " + title + " " + author + " " + postBody);
    
//     var queryUrl = "/update/"+ id;

//     var putData = {
//         postTitle: title,
//         postAuthor: author,
//         postBody: postBody
//     }

//     $.ajax({
//         url: queryUrl,
//         method: "PUT",
//         data: putData
//     });
// })