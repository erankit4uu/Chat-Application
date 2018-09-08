package com.example.ankitchaturvedi.chatapplication.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ankitchaturvedi.chatapplication.Fragment.ChatsFragment;
import com.example.ankitchaturvedi.chatapplication.Fragment.ContactFragment;
import com.example.ankitchaturvedi.chatapplication.Fragment.StatusFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ContactFragment contactFragment = new ContactFragment();
                return contactFragment;

            case 1:
                ChatsFragment chatsFragment = new ChatsFragment();
                return chatsFragment;

            case 2:
                StatusFragment statusFragment = new StatusFragment();
                return statusFragment;

                default:
                    return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
         super.getPageTitle(position);

         switch (position){
             case 0:
                  return "Contacts";
             case 1:
                 return "Chats";
             case 2:
                 return "Status";

                 default:
                     return null;
         }
    }
}
