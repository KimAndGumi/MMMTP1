package gla.m2.istic.fr.tppriseenmain.services;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by nirina on 13/02/17.
 */

public class MyAndroidFirebaseInstanceIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh(){
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
    }

    private void sendRegistrationToServer(String token){

    }
}
