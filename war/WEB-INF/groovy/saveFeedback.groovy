log.info params.name
log.info params.email
log.info params.comments
mail.send from: params.email,
		  	to: "sanaulla123@gmail.com",
		  	subject: "STM Explorer Feedback, By: ${params.name}",
		  	htmlBody: params.comments,
		  	attachments:[]
		  	
request.title = "Feedback Saved"
forward '/saveSuccessful.gtpl'