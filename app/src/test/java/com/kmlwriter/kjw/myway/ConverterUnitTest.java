package com.kmlwriter.kjw.myway;

import com.kmlwriter.kjw.myway.model.realmModel.RealmFriendPopulated;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.FriendPopulated;

import org.junit.Test;

import java.util.ArrayList;

import io.realm.RealmList;

import static org.junit.Assert.assertEquals;

/**
 * Created by kjw on 2018. 1. 9..
 */

public class ConverterUnitTest {
    private Converter converter;
    private ArrayList<String> dummyStringArray = new ArrayList<>();
    private RealmList<String> expectedStringArray = new RealmList<>();

    private ArrayList<FriendPopulated> dummyPopulatedFriends = new ArrayList<>();
    private RealmList<RealmFriendPopulated> expectedRealmPopulatedFriends = new RealmList<>();

    @Test
    public void convertFromEmptyStringArray() throws Exception {
        converter = new Converter();
        assertEquals(expectedStringArray, converter.FromStringArrayList(dummyStringArray));

    }
    @Test
    public void convertFromStringArray() throws Exception {
        converter = new Converter();
        dummyStringArray.add("a");
        dummyStringArray.add("b");

        expectedStringArray.add("a");
        expectedStringArray.add("b");
        assertEquals(expectedStringArray, converter.FromStringArrayList(dummyStringArray));

    }
    @Test
    public void convertFromPopulatedFriends() throws Exception{
        converter = new Converter();
        dummyPopulatedFriends.add(new FriendPopulated().setApp("facebook").setAppId("12345678").setNick("김지운"));
        dummyPopulatedFriends.add(new FriendPopulated().setApp("facebook").setAppId("12345678").setNick("김지운"));

        expectedRealmPopulatedFriends.add(new RealmFriendPopulated().setApp("facebook").setAppId("12345678").setNick("김지운"));
        expectedRealmPopulatedFriends.add(new RealmFriendPopulated().setApp("facebook").setAppId("12345678").setNick("김지운"));

        assertEquals(expectedRealmPopulatedFriends.get(0).getApp(), ((RealmFriendPopulated)converter.FromPopulatedFriendArray(dummyPopulatedFriends).get(0)).getApp());
    }
    @Test
    public void convertFromPopulatedFriendstoArray() throws Exception{
        converter = new Converter();
        dummyPopulatedFriends.add(new FriendPopulated().setApp("facebook").setAppId("12345678").setNick("김지운"));
        dummyPopulatedFriends.add(new FriendPopulated().setApp("facebook").setAppId("12345678").setNick("김지희"));


        expectedRealmPopulatedFriends.add(new RealmFriendPopulated().setApp("facebook").setAppId("12345678").setNick("김지운"));
        expectedRealmPopulatedFriends.add(new RealmFriendPopulated().setApp("facebook").setAppId("12345678").setNick("김지희"));


        assertEquals(expectedRealmPopulatedFriends.get(0).getNick(),((RealmFriendPopulated)converter.FromPopulatedFriendArray(dummyPopulatedFriends).get(0)).getNick());
    }
    @Test
    public void convertFromEmptyPopulatedFriends() throws Exception{
        converter = new Converter();

        assertEquals(expectedRealmPopulatedFriends,(converter.FromPopulatedFriendArray(dummyPopulatedFriends)));
    }
}
