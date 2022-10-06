//function updateGeseStock() {
//    $.get("update_GESE").done(function(fragment) { // get from controller
//        $("#row-GESE").replaceWith(fragment); // update snippet of page
//    });
//}
//function updateMarkoStock() {
//    $.get("update_MARKO").done(function(fragment) { // get from controller
//        $("#row-MARKO").replaceWith(fragment); // update snippet of page
//    });
//}
$("#imageListFile").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings("#api-file-label").html(fileName);
});
$("#markoFile").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings("#marko-file-label").html(fileName);
});
$("#ergoldFile").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings("#ergold-file-label").html(fileName);
});
$("#geseFile").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings("#gese-file-label").html(fileName);
});
$("#garettFile").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings("#garett-file-label").html(fileName);
});
$("#wikoFile").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings("#wiko-file-label").html(fileName);
});
$("#attrFile").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings("#attr-file-label").html(fileName);
});
$("#imageListFile").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings("#kropa-file-label").html(fileName);
});

function updateAlkorStock() {
    $.get("update_ALKOR").done(function(fragment) { // get from controller
        $("#row-ALKOR").replaceWith(fragment); // update snippet of page
    });
}
function updateGeseFileDate() {
    $.get("update_GESE_xml_date").done(function(fragment) { // get from controller
        $("#row-GESE-xml_date").replaceWith(fragment); // update snippet of page
    });
}
function updateErgoldStock() {
    $.get("update_ERGOLD").done(function(fragment) { // get from controller
        $("#row-ERGOLD").replaceWith(fragment); // update snippet of page
    });
}
function updateGarettFileDate() {
    $.get("update_GARETT_xml_date").done(function(fragment) { // get from controller
        $("#row-GARETT-xml_date").replaceWith(fragment); // update snippet of page
    });
}

function updateJubilerStock() {
    $.get("update_JUBILER").done(function(fragment) { // get from controller
        $("#row-JUBILER").replaceWith(fragment); // update snippet of page
    });
}

function updateZibiStock() {
    $.get("update_ZIBI").done(function(fragment) { // get from controller
        $("#row-ZIBI").replaceWith(fragment); // update snippet of page
    });
}

function updateTimexStock() {
    $.get("update_TIMEX").done(function(fragment) { // get from controller
         $("#row-TIMEX").replaceWith(fragment); // update snippet of page
    });
}
function updateRow() {
    $.get('edit').done(function(fragment) { // get from controller
        $("#row468271").replaceWith(fragment); // update snippet of page
    });
}
function reload_single_row(elt) {
$('#'+elt).removeClass('btn-default');
$('#'+elt).addClass('btn-simple btn-info');

var $row = $("#row_"+elt);
var $stock = $row.find('.minimal_stock_input').val();
var $stock_maks = $row.find('.maksymal_stock_input').val();

var $stock_cell = $row.find('.minimal_stock_cell').html();

$row.find('.minimal_stock_input').removeClass('zmniejszyc');
$row.find('.minimal_stock_input').removeClass('zwiekszyc');

if(parseInt($stock) < parseInt($stock_cell)){
$row.find('.minimal_stock_input').addClass('zmniejszyc');
$row.find('.minimal_stock_cell').html($stock);
var $stock_maks = $row.find('.maksymal_stock_input').val();
    if(parseInt($stock_maks) < parseInt($stock)){
        $row.find('.maksymal_stock_input').addClass('error_input');
        alert("Stan maksymalny nie może być mniejszy niż stan minimalny!");
    }else{
        $row.find('.maksymal_stock_input').removeClass('error_input');
        $row.find('.minimal_stock_cell').html($stock);
        $.post('/update/'+elt+'_'+$stock+'_'+$stock_maks);
    }
}
else if(parseInt($stock) > parseInt($stock_cell)){
 $row.find('.minimal_stock_input').addClass('zwiekszyc');
 $row.find('.minimal_stock_cell').html($stock);
 var $stock_maks = $row.find('.maksymal_stock_input').val();
    if(parseInt($stock_maks) < parseInt($stock)){
        $row.find('.maksymal_stock_input').addClass('error_input');
        alert("Stan maksymalny nie może być mniejszy niż stan minimalny!");
    }else{
        $row.find('.maksymal_stock_input').removeClass('error_input');
        $row.find('.minimal_stock_cell').html($stock);
        $.post('/update/'+elt+'_'+$stock+'_'+$stock_maks);
    }
}
else if(parseInt($stock) == parseInt($stock_cell)){
 $row.find('.minimal_stock_input').removeClass('zmniejszyc');
 $row.find('.minimal_stock_input').removeClass('zwiekszyc');
 $row.find('.minimal_stock_cell').html($stock);
 var $stock_maks = $row.find('.maksymal_stock_input').val();
    if(parseInt($stock_maks) < parseInt($stock)){
        $row.find('.maksymal_stock_input').addClass('error_input');
        alert("Stan maksymalny nie może być mniejszy niż stan minimalny!");
    }else{
        $row.find('.maksymal_stock_input').removeClass('error_input');
        $row.find('.minimal_stock_cell').html($stock);
        $.post('/update/'+elt+'_'+$stock+'_'+$stock_maks);
    }
}
else if(parseInt($stock_maks) < parseInt($stock)){
        $row.find('.maksymal_stock_input').addClass('error_input');
        alert("Stan maksymalny nie może być mniejszy niż stan minimalny!");
}
}

function reload_icon(id) {
    var $icon = $(id),
        animateClass = "icon-refresh-animate";
    $icon.addClass(animateClass);
    // setTimeout is to indicate some async operation
    window.setTimeout(function() {
        $icon.removeClass(animateClass);
    }, 99999);
};

$(document).ready(function() {
    $('#datepicker_start').Zebra_DatePicker({
        format: 'd/m/Y',
        pair: $('#datepicker_end')
    });
    $('#datepicker_end').Zebra_DatePicker({
        format: 'd/m/Y',
        direction: 1
    });

    $('.table_row').each(function(i, row) {
        const roundToNearest5 = x => Math.ceil(x / 5) * 5
        var $row = $(this).closest("tr"),
            $tds = $row.find('.sales_level_cell').html();
            $row.find('.minimal_stock_input').val(roundToNearest5($tds));

        var $stock = $row.find('.minimal_stock_cell').html();
        var $stock_maks = $row.find('.minimal_stock_input').val();

        if(parseInt($stock_maks) < parseInt($stock)){
            $row.find('.minimal_stock_input').addClass('zmniejszyc');

        }if(parseInt($stock_maks) > parseInt($stock)){
            $row.find('.minimal_stock_input').addClass('zwiekszyc');
        }
    });

    $('.table_row_zamowienie').each(function(i, row) {
        const roundToNearest5 = x => Math.ceil(x / 5) * 5
        var $row = $(this).closest("tr");
        var $stan = $row.find('.stan').html();
        var $stan_minimalny = $row.find('.stan_minimalny').html();
        var $dostawcy_dost = $row.find('.dostawcy_dostarcza').html();
        var $wynik = parseInt($stan_minimalny) - parseInt($stan) - parseInt($dostawcy_dost);
        var $waga = $row.find('.waga').html().replace(',', '.');
        var $ilosc_ma = $row.find('.ilosc_mag').html();

        var $waga_sum = parseFloat($waga) * parseFloat($ilosc_ma);
        $row.find('.waga_suma').html((parseFloat($ilosc_ma) * parseFloat($waga)).toFixed(2));

        if(parseInt($wynik) > 0){
            var $zaokr = roundToNearest5($wynik);
            $row.find('.do_zamowienia').val($zaokr);
        }else{
            $row.find('.do_zamowienia').val($wynik);
        }

    });

});

$("#search_button_producent").click(function() {
    $("#input_selected_producent").val(select.selected());
});

$("#clear_dostawca").click(function() {
    $('#datepicker_start').val('');
    $('#datepicker_end').val('');
    select.set([]);
});


$('.icon-minimal-up').on('click', function(e) {
    e.preventDefault();
    var $row = $(this).closest("tr"), // Finds the closest row <tr>
        $tds = $row.find('.minimal_stock_input').val();
    var a = parseInt($tds);
    $row.find('.minimal_stock_input').val(a + 5);
});

$('.icon-minimal-down').on('click', function(e) {
    e.preventDefault();
    var $row = $(this).closest("tr"), // Finds the closest row <tr>
        $tds = $row.find('.minimal_stock_input').val();
    var a = parseInt($tds);
    $row.find('.minimal_stock_input').val(a - 5);
});

$('#timepicker1').timepicker({
    showMeridian: false,
});

$('#timepicker0').timepicker({
    minuteStep: 1,
    showMeridian: false,
    showInputs: false,
});

$('#clear_cache_button').on('click', function(e) {
    event.respondWith(purgeCache(event.request));
});

addEventListener('fetch', event => {
    event.respondWith(purgeCache(event.request))
})

async function purgeCache(request) {

    const url = new URL('https://www.marko.pl/');
    // If the path doesn't begin with our protected prefix, just pass the request through.
    if (!url.pathname.startsWith("/__purge_cache")) {

        return fetch(request)
    }

    // Lets validate the zone id, and return an error if invalid
    let zoneIdValidated = (new RegExp("^([a-z0-9]{32})$")).test(url.searchParams.get('zone'));

    if (!zoneIdValidated) {

        return new Response('Invalid Zone ID', {
          status: 500
        });
    }

    let content = '{"purge_everything":true}'
    let headers = {
        'Content-Type': 'application/json',
        'X-Auth-Email': 'admin@marko.pl', // Cloudflare API Auth Email
        'X-Auth-Key': 'a0f79f71b1d267946d5c8afddcb96fe4d21e7' //Cloudflare API Auth Key
    }

    const init = {
        method: 'POST',
        headers: headers,
        body: content
    }

    const response = await fetch('https://api.cloudflare.com/client/v4/zones/'+url.searchParams.get('zone')+'/purge_cache', init)

    return response

}