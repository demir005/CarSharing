<?php

$poruka = array();

if(isset($_POST['id'])){

    $id = $_POST['id'];



    // $dns = 'mysql:dbname=pz;host=127.0.0.1';
    // $user = 'root';
    //    $password = '';

    $dns = 'mysql:dbname=pz;host=localhost';
    $user = 'root';
    $password = '';

    try{
        $con = new PDO($dns, $user, $password);
    }

    catch (PDOException $e) {
        echo 'Konekcija nije uspjela: ' . $e->getMessage();
    }

        $result = $con->prepare("DELETE FROM oglasi WHERE id=?");
        $result->bindValue(1, $id, PDO::PARAM_INT); 

        $result->execute();

    if ($result) {
        $poruka["success"] = 1;
        $poruka["tekst"] = "Ads deleted successfully";
 
        echo json_encode($poruka);
    }

    else{
        $poruka["uspjeh"] = 0;
        $poruka["tekst"] = "Ads not deleted";
 
        echo json_encode($poruka);
    }


}

else{
    $poruka["uspjeh"] = 0;
    $poruka["tekst"] = "Nedostaju polja";
 
    echo json_encode($poruka);
}
?> 
