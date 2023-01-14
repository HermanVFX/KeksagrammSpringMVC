const photoBtn = document.querySelector('#userPhotoBlockBtn');
const photoBlock = document.querySelector('#userPhotoBlock');
const postBtn = document.querySelector('#userPostBlockBtn');
const postBlock = document.querySelector('#userPostBlock');

function userPageSelector() {
    if (photoBtn.checked === true) {
        photoBlock.classList.remove("isHidden");
        postBlock.classList.add("isHidden");
    }
    if (postBtn.checked === true)  {
        postBlock.classList.remove("isHidden");
        photoBlock.classList.add("isHidden");
    }
}
