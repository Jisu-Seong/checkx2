import axios from "axios";

const host = `http://localhost:8080/api/member`;

export const loginPost = async (loginParam) => {
    const header = {headers: { "Content-Type": "x-www-form-urlencoded"}};

    const form = new FormData();
    form.append("username", loginParam.email);
    form.append("password", loginParam.pw);

    const res = await axios.post(`${host}/login`, form, header);

    return res.data;
}

export const joinPost = async (joinParam) => {
    const header = {headers : {"Content-Type": "x-www-form-urlencoded"}};
    const form = new FormData();
    form.append("email", joinParam.email);
    form.append("password", joinParam.pw);
    form.append("nickname", joinParam.nickname);

    const res = await axios.post(`${host}/join`, form, header);
    return res.data;

}