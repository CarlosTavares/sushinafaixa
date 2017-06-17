/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function entregaAgora(id) {
    $.post("alteraStatusCompra",{'id':id},function(data){
        $("#compra_"+id).html(data);
    });
}
