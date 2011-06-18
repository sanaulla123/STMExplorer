<html>
    <head>
        <title>STM Explorer | ${request.title}</title>
        <link rel="stylesheet" href="/css/reset.css" type="text/css" media="screen" charset="utf-8">
    	<link rel="stylesheet" href="/css/jquery-ui-1.8.13.custom.css" type="text/css" media="screen" charset="utf-8">
    	<link rel="stylesheet" href="/css/grid.css" type="text/css" media="screen"  charset="utf-8">
    	<!-- <link rel="stylesheet" href="/css/forms.css" type="text/css" media="screen" charset="utf-8"> -->
    	<link rel="stylesheet" href="/css/general.css" type="text/css" media="screen" charset="utf-8">
    	<link rel="stylesheet" href="/css/css3.css" type="text/css" media="screen" charset="utf-8">
    	
    	<script src="/js/modernizr-1.7.min.js" type="text/javascript" charset="utf-8"></script>
    	<script src="/js/jquery-1.5.1.min.js" type="text/javascript" charset="utf-8"></script>
    	<script src="/js/jquery-ui-1.8.13.custom.min.js" type="text/javascript" charset="utf-8"></script>
    	
    	<script type="text/javascript" charset="utf-8">
    		\$(function(){

				// Accordion
				\$("#accordion").accordion({ header: "h3" });
	
				// Tabs
				\$('#tabs').tabs();
	

				// Dialog			
				\$('#dialog').dialog({
					autoOpen: false,
					width: 600,
					buttons: {
						"Ok": function() { 
							\$(this).dialog("close"); 
						}, 
						"Cancel": function() { 
							\$(this).dialog("close"); 
						} 
					}
				});
				
				// Dialog Link
				\$('#dialog_link').click(function(){
					\$('#dialog').dialog('open');
					return false;
				});	
				\$("button").button();
				
				//hover states on the static widgets
				\$('#dialog_link, ul#icons li').hover(
					function() { \$(this).addClass('ui-state-hover'); }, 
					function() { \$(this).removeClass('ui-state-hover'); }
				);
				
				
			});
    	</script>
    </head>
    <body class="fontface">
    	<div class="row">
    	<header>
	    	<div class="logo col_7 col shadow">STM Explorer</div>
        	<nav class="col_8 col">
        	<ul>
            	<li><a href="/" class="bold gradient_radial">Home</a></li>
            	<li><a href="/about" class="bold gradient_radial">About</a></li>
                <li class="last"><a href="/feedback" class="bold gradient_radial">Feedback</a></li>
            </ul>
       		</nav><!-- nav col_9 -->
	    	<div class="clear"></div><!-- clear -->
	    </header>
	    </div>
        	
