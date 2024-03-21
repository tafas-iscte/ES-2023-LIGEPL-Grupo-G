const fileInput = document.getElementById('csvFile');
const githubInput = document.getElementById('githubLink');
const submitBtn = document.getElementById('submitBtn');

fileInput.addEventListener('change', () => {
  githubInput.disabled = fileInput.value !== '';
});

githubInput.addEventListener('input', () => {
  fileInput.disabled = githubInput.value !== '';
});

submitBtn.addEventListener('click', () => {
  if (fileInput.value !== '' && githubInput.value !== '') {
    alert('Only one file can be uploaded.');
  } else if (fileInput.value === '' && githubInput.value === '') {
    alert('No file uploaded.');
  } else {
    // Redirect to loading.html
    window.location.href = 'loading.html';
  }
});