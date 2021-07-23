    $(document).ready(function(){
      $('.select-left').on('click','ul>li>a',function(){ 
          if ($(this).next().css('display') == "none") {
              $(this).next('div').slideDown(300);
              $(this).css("color","rgb(59, 17, 128)")
          }else {
              $(this).next('div').slideUp(300);
              $(this).css("color","rgb(156, 155, 155)")
          }
      })
    })
