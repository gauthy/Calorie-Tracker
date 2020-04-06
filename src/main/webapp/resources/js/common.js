
$(document).ready(function () {

    $("#search-form").submit(function (event) {

        event.preventDefault();

        add_user_calories();

    });
    
    
    $("#delete-form").submit(function (event) {

        event.preventDefault();

        delete_user();

    });
    
});

function add_user_calories() {

    var search = {}
    search["itemName"] = $("#itemName").val();
    search["totalCalories"] = $("#totalCalories").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/user-calories",
        data: JSON.stringify(search),
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Success</h4>";
            $('#feedback').html(json);

            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Error</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            $("#btn-search").prop("disabled", false);

        }
    });

}

function show(evt, tabName) {
	  var i, tabcontent, tablinks;
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }
	  document.getElementById(tabName).style.display = "block";
	  evt.currentTarget.className += " active";
	  
	  
	   if(tabName==='view-page'){
		  view_page();
	   }
	   else if(tabName==='view-users-page'){
		   view_users();
	   }
	   else if(tabName==='view-user-calories-page'){
		   view_user_calories();
	   }
	  
}


function view_page(){
	
	 $.ajax({
		type: "GET",
        contentType: "application/json",
        url: "/user-calories",
        cache: false,
        dataType: 'json',
        timeout: 600000,
        success: function (resp) {
        	  var trHTML = '';
             var limit=resp.calorieLimit;
             var totalCount=0;
             $.each(resp.userCalories, function (i,item) {
            	    totalCount=totalCount+item.totalCalories;
            	    if(totalCount<limit){
                     trHTML +=
                         '<tr bgcolor="#00FF00"><td>'
                         + item.itemName
                         + '</td><td>'
                         + item.totalCalories 
                         + '</td><td>'
                         + item.createdDate 
                         + '</td></tr>';
  
            	    }
            	    else{
            	    	     trHTML +=
                              '<tr bgcolor="#FF0000"><td>'
                              + item.itemName
                              + '</td><td>'
                              + item.totalCalories 
                              + '</td><td>'
                              + item.createdDate 
                              + '</td></tr>';
       
                 	   
            	    }
                   
             });
             $('#items-list').html(trHTML);
         },
         error: function (err) {
             let error = `Ajax error: ${err.status} - ${err.statusText}`;
         }
     })
}

function view_users(){
	 $.ajax({
		type: "GET",
       contentType: "application/json",
       url: "/user-calories/users",
       cache: false,
       dataType: 'json',
       timeout: 600000,
       success: function (resp) {
            var trHTML = '';
            $.each(resp, function (i) {
                    trHTML +=
                        '<tr><td>'
                        + resp[i].username
                        + '</td><td>'
                        + resp[i].userCalorieLimit 
                        + '</td></tr>';
            });
            $('#users-list').html(trHTML);
        },
        error: function (err) {
            let error = `Ajax error: ${err.status} - ${err.statusText}`;
        }
    })
}

function view_user_calories(){
	
	 $.ajax({
		type: "GET",
      contentType: "application/json",
      url: "/user-calories/all",
      cache: false,
      dataType: 'json',
      timeout: 600000,
      success: function (resp) {
           var trHTML = '';
           $.each(resp, function (i) {
                   trHTML +=
                       '<tr><td>'
                       + resp[i].userId
                       + '</td><td>'
                       + resp[i].itemName
                       + '</td><td>' 
                       + resp[i].totalCalories 
                       + '</td></tr>';
           });
           $('#user-calorie-list').html(trHTML);
       },
       error: function (err) {
           let error = `Ajax error: ${err.status} - ${err.statusText}`;
       }
   })
}


function delete_user(){
		    var search = {};
		    search["userName"] = $("#userName").val();
            var userName=search["userName"];
		    $("#btn-search").prop("disabled", true);

		    $.ajax({
		        type: "DELETE",
		        contentType: "application/json",
		        url: "/user-calories/",
		        data: JSON.stringify(search),
		        cache: false,
		        timeout: 600000,
		        success: function (data) {

		            var json = "<h4>Successfully Deleted</h4>";
		            $('#feedback').html(json);

		            $("#btn-search").prop("disabled", false);

		        }
		    });
}

