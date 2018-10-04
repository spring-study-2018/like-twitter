import React from 'react';

import dashboard from './dashboard';
import tweet from './tweet';

import DashboardIcon from '@material-ui/icons/Dashboard';
import FavoriteIcon from '@material-ui/icons/Favorite';

export default [
    {
        path: "/dashboard",
        name: "Dashboard",
        icon: DashboardIcon,
        subPages: [
            {
                path: "/",
                component: dashboard.Dashboard
            },
            {
                path: "/remove/me",
                component: dashboard.RemoveMe
            }
        ]
    },
    {
        path: "/template",
        name: "Template",
        icon: FavoriteIcon,
        subPages: [
            {
                path: "/",
                component: () => <div>Template</div>
            }
        ]
    },
    {
        path: "/tweet",
        name: "Tweet",
        icon: FavoriteIcon,
        subPages: [
            {
                path: "/",
                component: tweet.PostTweet
            }
        ]
    }
];
