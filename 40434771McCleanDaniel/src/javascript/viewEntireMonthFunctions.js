// Get value of month selector and update display to show exhibits in that month
window.onload = () => {
    const monthSelector = document.getElementById("monthChoice");
    console.log(monthSelector)
    monthSelector.addEventListener('change', () => {
        const month = monthSelector.value
        const monthGrid = document.getElementById('monthGrid');
        const oldMonth = document.getElementById('month')
        const monthBox = document.createElement('div');
        monthBox.innerHTML = monthSelector.options[monthSelector.selectedIndex].text
        monthBox.id = 'month'
        monthBox.className = 'bg-gray-400 pl-2 font-bold border-l-2 border-r border-b-2'
        monthGrid.replaceChild(monthBox, oldMonth)
        for (let i = 0; i < exhibitPlan[month].length; i++) {
            const oldExhibit = document.getElementById('exhibit'+i)
            const exhibitBox = document.createElement('div');
            exhibitBox.innerHTML = exhibitPlan[month][i]
            exhibitBox.id = 'exhibit'+i
            const borderRight = (i%(exhibitPlan[month].length-1)==0 && i!=0) ? 'border-r-2' : "border-r"
            exhibitBox.className = 'bg-gray-400 pl-2 border-b-2 '+borderRight
            monthGrid.replaceChild(exhibitBox, oldExhibit)
        }

    })
};