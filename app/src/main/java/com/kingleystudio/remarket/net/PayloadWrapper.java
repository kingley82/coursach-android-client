package com.kingleystudio.remarket.net;

import androidx.annotation.NonNull;

import com.kingleystudio.remarket.Config;
import com.kingleystudio.remarket.models.IBaseMessage;
import com.kingleystudio.remarket.models.Types;

import org.json.JSONException;
import org.json.JSONObject;


public class PayloadWrapper {
    private JSONObject data;

    public PayloadWrapper(IBaseMessage message) throws JSONException {
        this.data = new JSONObject();
        this.data.put(Types.EVENT, message.getType());
        this.data.put(Types.USERNAME, Config.currentUser == null ? "" : Config.currentUser.getUsername());
        this.data.put(Types.UID, Config.currentUser == null ? -1 : Config.currentUser.getId());
        this.data.put(Types.DEVICE_ID, Config.getDeviceID(Config.baseContext));
        this.data.put(Types.PAYLOAD, message.toJsonObject());
    }

    public String getType() throws JSONException {
        return (String) this.data.get(Types.EVENT);
    }

    @NonNull
    @Override
    public String toString() {
        return this.data.toString() + "\n";
    }
}
