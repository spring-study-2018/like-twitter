import React from 'react';
import classes from './index.css';
import {Link} from 'react-router-dom';

class PostTweet extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <div className="form">
                    내용 : <textarea value={tweet}/>
                    멤버아이디(임시) : <input value={tweet}/>
                </div>
                <div className="create-button" onClick={this.confirm}>
                    추가
                </div>
            </div>
        );
    }
    confirm() {

    }

}

export default PostTweet;
