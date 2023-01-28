<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<%@include file="normal_navbar.jsp"%>
	<main class="d-flex align-items-center pp" style="height: 100vh">
		<div class="container">

			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center pp text-white">
						<span class="fa fa-user-plus"></span><br> Register Here
					</div>
					<div class="card-body">
						<form id="reg-form" action="RegisterServlet" method="POST">
							<div class="form-group">
								<label for="username">UserName</label> <input name="user_name"
									required type="text" class="form-control" id="user_name"
									aria-describedby="emailHelp" placeholder="Enter name">

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="user_email" required type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email"> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									email with anyone else.</small>
							</div>


							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									name="user_password" required type="password" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>

							<div class="form-group">
								<label for="gender">Gender</label><br> <input required type="radio"
									id="gender" name="gender" value="male">Male <input
									required type="radio" id="gender" name="gender" value="female">Female
							</div>
							<div class="form-group"></div>

							<div class="form-check">
								<input name="check" type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Terms And Condition</label>
							</div>
							<br>
							<div class="container text-center" id="loader"
								style="display: none">
								<span class="fa fa-refresh fa-spin fa-4x"></span>
							</div>
							<br>
							<button id="submit-btn" type="submit" class="btn btn-primary">Submit</button>
						</form>

					</div>

				</div>
			</div>

		</div>
	</main>






	<script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/js.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js" integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script>
            $(document).ready(function () {
                console.log("loaded........")
                $('#reg-form').on('submit', function (event) {
                    event.preventDefault();
                    let form = new FormData(this);
                    $("#submit-btn").hide();
                    $("#loader").show();
                    //send register servlet:
                    $.ajax({
                        url: "RegisterServlet",
                        type: 'POST',
                        data: form,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data)
                            $("#submit-btn").show();
                            $("#loader").hide();
                            
                            
                            if(data.trim()==='Done'){
                            	swal("Register Successfull...Redirecting Login page")
                            .then((value) => {
                              window.location="login_page.jsp"
                            });
                            }else{
                                swal(data);

                            }
                            
                            
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                        	 $("#submit-btn").show();
                             $("#loader").hide();
                            swal("something went wrong..try again");
                        },
                        processData: false,
                        contentType: false
                    });
                });
            });
        </script>

</body>
</html>